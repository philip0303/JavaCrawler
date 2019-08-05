package philip.druklists.druk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import philip.druklists.druk.entity.DrukData;
import philip.druklists.druk.repository.DrukDataRepository;
import philip.druklists.druk.service.DrukDataService;

@Service
public class DrukDataServiceImpl implements DrukDataService
{
    @Autowired
    private DrukDataRepository drukDataRepository;


    @Override
    public void insertDruk(DrukData drukData) {
        if ( null != drukData)
        {
            drukData = drukDataRepository .save(drukData);
            System.out.println("存储的数据是："+drukData.toString());

        }

    }
}
