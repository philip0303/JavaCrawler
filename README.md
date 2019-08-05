
# JavaCrawler
这是一个初级的Java爬虫项目（This is a basic Java crawler project）

要求是：
    获取到所有的药品的属性名称，比如第一个tr标签下有两个td标签，
    我需要获取第二个标签的值。

爬虫页面格式如下：

<table class="drug-lists">
    <tr class="odd">
        <td>活性成分</td>
        <td>阿莫西林; 克拉维酸钾</td>
    </tr>
    <tr class="even">
        <td>活性成分（英文）</td>
        <td>Amoxicillin; Clavulanate Potassium</td>
    </tr>
    <tr class="odd">
        <td>药品名称</td>
        <td>阿莫西林克拉维酸钾片</td>
    </tr>
    <tr class="even">
        <td>药品名称（英文）</td>
        <td>Amoxicillin and Clavulanate Potassium Tablets</td>
    </tr>
    <tr class="odd">
        <td>商品名</td>
        <td>力百汀</td>
    </tr>
    <tr class="even">
        <td>商品名（英文）</td>
        <td>Augmentin</td>
    </tr>
    <tr class="odd">
        <td>剂型</td>
        <td>片剂</td>
    </tr>
    <tr class="even">
        <td>给药途径</td>
        <td>口服</td>
    </tr>
    <tr class="odd">
        <td>规格</td>
        <td>0.625g</td>
    </tr>
    <tr class="even">
        <td>参比制剂</td>
        <td>是</td>
    </tr>
    <tr class="odd">
        <td>标准制剂</td>
        <td>是</td>
    </tr>
    <tr class="even">
        <td>TE代码</td>
        <td></td>
    </tr>
    <tr class="even">
        <td>ATC代码</td>
        <td>J01CA04</td>
    </tr>
    <tr class="odd">
        <td>批准文号/注册证号</td>
        <td>H20160646</td>
    </tr>
    <tr class="even">
        <td>批准日期</td>
        <td>1999-03-12</td>
    </tr>
    <tr class="odd">
        <td>上市许可持有人</td>
        <td>Beecham Group Plc</td>
    </tr>
    <tr class="even">
        <td>生产厂商</td>
        <td>SmithKline Beecham Limited</td>
    </tr>
    <tr class="odd">
        <td>上市销售状况</td>
        <td>上市销售中</td>
    </tr>
    <tr class="odd">
        <td>收录类别</td>
        <td>进口原研药品</td>
    </tr>
    <tr class="even">
        <td>专利信息</td>
        <td class="table">
            <table style="width: 100%;">
                <thead>
                <tr>
                    <th>专利号</th>
                    <th>专利到期日</th>
                    <th>专利类型</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>无</td>
                    <td></td>
                    <td></td>
                </tr>
                </tbody>
            </table>
        </td>
    </tr>

    <tr class="odd">
        <td>说明书</td>
        <td>
            暂无
        </td>
    </tr>
    <tr class="odd">
        <td>审评报告</td>
        <td>
            暂无
        </td>
    </tr>
</table>


