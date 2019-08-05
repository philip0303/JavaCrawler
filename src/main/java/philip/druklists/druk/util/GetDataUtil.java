package philip.druklists.druk.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import philip.druklists.druk.entity.PatenData;
import philip.druklists.druk.repository.DrukDataRepository;
import philip.druklists.druk.repository.PatenDataRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetDataUtil {

    @Autowired
    private DrukDataRepository drukDataRepository;

    @Autowired
    private PatenDataRepository patenDataRepository;


    //根据url获取html数据
    private Document getHtmlTextByUrl(String url) {
        Document document = null;
        try {
            int i = (int) (Math.random() * 1000);////做一个随机延时，防止网站屏蔽
            while (i != 0) {
                i--;
            }
            document = Jsoup.connect(url)
                    .data("query", "Java")
                    .userAgent("Mozilla")
                    .cookie("auth", "token")
                    .timeout(300000).post();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                document = Jsoup.connect(url).timeout(5000000).get();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return document;
    }

    //根据元素属性获取某个元素内的elements列表
    private Elements getElementByTagName(Document document, String tagName) {
        Elements elements = null;
        elements = document.getElementsByTag(tagName);
        return elements;
    }

    //从页面获取需要的信息数据
    public ArrayList getProvice(String url, String tageName) {
        ArrayList result = new ArrayList();
        //从网络上获取网页
        Document document = getHtmlTextByUrl(url);
        if (document != null) {
            //获取页面上所有tr标签的集合
            Elements elements = getElementByTagName(document, tageName);
            for (Element tr : elements) {// 依次循环每个元素，也就是一个tr
                if (tr != null) {

                    //当tr标签中包含th标签，但是不包含td标签 或者时  tr子标签长度为7，并且包含td标签时，跳出本次循环
                    if((tr.toString().contains("th") && !tr.toString().contains("td")) || (tr.childNodeSize() == 7 && tr.toString().contains("td")))
                    {
                        continue;
                    }else if ("专利信息".equals(tr.children().select("td").first().text())) {
                        //判断tr中的标签信息，不能为专利信息
                        //专利信息的专门获取的方法
                        result.add(getPatentMessage(tr));
                    } else if ("说明书".equals(tr.children().select("td").first().text())) {
                        //说明书路径文件获取
                        result.add(getInstructionManual(tr));
                    }else
                    {
                        //直接获取tr标签下最后一个td标签中的值
                        //并将其放在结果集中
                        if (null == tr.child(1).text()) {

                            result.add("");
                        } else {
                            result.add(tr.child(1).text());
                        }
                    }

                }
            }
        }
        if (result.size() != 22)
        {
            result.add(19, new PatenData());
        }
        return result;
    }

    /**
     * 获取专利信息的
     * 返回一个专利信息对象
     */

    private PatenData getPatentMessage(Element tr) {

        List<String> stringLists = new ArrayList<String>();
        //从专利信息标签中获取第二个td标签
        Element secondTd = tr.child(1);
        //从第二个td标签中获取第二个tr标签
        Element secondTr = secondTd.children().select("tr").last();
        //对tr标签进行循环，去除他的td属性值
        if (null != secondTr) {
            for (Element td : secondTr.children()) {

                if (null == td.text() || "".equals(td.text())) {
                    stringLists.add("无");
                }
                stringLists.add(td.text());
            }
        }
        PatenData patenData = new PatenData();
        patenData.setPatentNo(stringLists.get(0));
        patenData.setPatentDueDate(stringLists.get(1));
        patenData.setPatentType(stringLists.get(2));

        System.out.println("专利信息："+patenData.toString());
        return patenData;
    }


    /**
     * 获取说明书下面a标签的连接url
     *
     * @param tr
     * @return
     */
    private String getInstructionManual(Element tr) {
        String result = null;
        //判断说明书标签的第二个td标签下是否还有标签
        if (null == tr.child(1).children() || "".equals(tr.child(1).children())) {
            result = tr.child(1).text();
        }
        result = tr.child(1).children().attr("abs:href").toString();
        System.out.println("获取到的连接是："+result);
        return result;
    }


}
