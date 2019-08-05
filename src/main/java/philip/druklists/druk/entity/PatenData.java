package philip.druklists.druk.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 专利信息表
 */
@Data
@Entity
@Table(name = "PATEN_DATA_TABLE")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class PatenData {

    @Id
    @Column(name="ID", length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    private String id;

    //专利号
    @Column(name="PATENT_NO", length = 64)
    private String patentNo;

    //专利到日期
    @Column(name="PATENT_DUE_DATE", length = 64)
    private String patentDueDate;

    //专利类型
    @Column(name="PATENT_TYPE", length = 64)
    private String patentType;

}
