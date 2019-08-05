package philip.druklists.druk;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import philip.druklists.druk.entity.DrukData;
import philip.druklists.druk.entity.PatenData;
import philip.druklists.druk.repository.DrukDataRepository;
import philip.druklists.druk.service.DrukDataService;
import philip.druklists.druk.util.GetDataUtil;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DrukDataServiceImplTest {

    @Autowired
    private DrukDataService drukDataService;

    @Test
    public void testAddData()
    {
        //93  345    367~372   497  557~604  621  627
        for (int i = 94; i <= 884; i++) {
            String url = "http://202.96.26.102/index/detail/id/" + i;
            String tagName = "tr";
            ArrayList resultData = new GetDataUtil().getProvice(url, tagName);
            DrukData drukData = new DrukData();
            drukData.setActiveIngredient(resultData.get(0).toString());
            drukData.setActiveIngredientEn(resultData.get(1).toString());
            drukData.setDrugName(resultData.get(2).toString());
            drukData.setDrugNameEn(resultData.get(3).toString());
            drukData.setProductName(resultData.get(4).toString());
            drukData.setProductNameEn(resultData.get(5).toString());
            drukData.setFormulation(resultData.get(6).toString());
            drukData.setRouteOfAdministration(resultData.get(7).toString());
            drukData.setSpecification(resultData.get(8).toString());
            drukData.setReferencePreparation(resultData.get(9).toString());
            drukData.setStandardPreparation(resultData.get(10).toString());
            drukData.setTECode(resultData.get(11).toString());
            drukData.setATCCode(resultData.get(12).toString());
            drukData.setApprovalRegistrationNumber(resultData.get(13).toString());
            drukData.setApprovalDate(resultData.get(14).toString());
            drukData.setListingLicenseHolder(resultData.get(15).toString());
            drukData.setManufacturer(resultData.get(16).toString());
            drukData.setListingStatus(resultData.get(17).toString());
            drukData.setInclusionCategory(resultData.get(18).toString());
            drukData.setPatenData((PatenData) resultData.get(19));

            drukData.setInstructionManual(resultData.get(20).toString());
            drukData.setReviewReport(resultData.get(21).toString());

            if (null != drukData)
            {
                drukDataService.insertDruk(drukData);
                System.out.println("存储的数据是：");
            }
            //保存数据
            System.out.println("第"+i+"次获取到的数据为："+drukData.toString());

        }



    }

}
