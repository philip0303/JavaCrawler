package philip.druklists.druk.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "DRUK_DATA_TABLE")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class DrukData {

    //主键id
    @Id
    @Column(name="ID", length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    private String id;

    //药品活性成分
    @Column(name="ACTIVE_INGREDIENT", length = 256)
    private String activeIngredient;

    //活性成分英文名称
    @Column(name="ACTIVE_INGREDIENTEN", length = 256)
    private String activeIngredientEn;

    //药品名称
    @Column(name="DRUG_NAME", length = 256)
    private String drugName;

    //药品名称
    @Column(name="DRUG_NAMEEN", length = 256)
    private String drugNameEn;

    //商品名
    @Column(name="PRODUCT_NAME", length = 256)
    private String productName;

    //商品名
    @Column(name="PRODUCT_NAMEEN", length = 256)
    private String productNameEn;

    //剂型
    @Column(name="FORMULATION", length = 256)
    private String formulation;

    //给药途径
    @Column(name="ROUTE_OF_ADMINISTRATION", length = 256)
    private String routeOfAdministration;

    //规格
    @Column(name="SPECIFICATION", length = 256)
    private String specification;

    //参比制剂
    @Column(name="REFERENCE_PREPARATION", length = 256)
    private String referencePreparation;

    //标准制剂
    @Column(name="STANDARD_PREPARATION", length = 256)
    private String standardPreparation;

    //TE代码
    @Column(name="TE_CODE", length = 256)
    private String TECode;

    //ATC代码
    @Column(name="ATC_CODE", length = 256)
    private String ATCCode;

    //批准文号/注册证号
    @Column(name="APPROVAL_REGISTRATIONNUMBER", length = 256)
    private String approvalRegistrationNumber;

    //批准日期
    @Column(name="APPROVAL_DATE", length = 64)
    private String approvalDate;

    //上市许可持有人
    @Column(name="LISTING_LICENSE_HOLDER", length = 64)
    private String listingLicenseHolder;

    //生产厂商
    @Column(name="MANUFACTURER", length = 256)
    private String manufacturer;

    //上市销售状况
    @Column(name="LISTING_STATUS", length = 256)
    private String listingStatus;

    //收录类别
    @Column(name="INCLUSION_CATEGORY", length = 256)
    private String inclusionCategory;

    //专利信息
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ID")
    private PatenData patenData;

    //说明书
    @Column(name="INSTRUCTION_MANUAL", length = 256)
    private String instructionManual;

    //审评报告
    @Column(name="REVIEW_REPORT", length = 256)
    private String reviewReport;


    public DrukData(String activeIngredient, String activeIngredientEn, String drugName, String drugNameEn, String productName, String productNameEn, String formulation, String routeOfAdministration, String specification, String referencePreparation, String standardPreparation, String TECode, String ATCCode, String approvalRegistrationNumber, String approvalDate, String listingLicenseHolder, String manufacturer, String listingStatus, String inclusionCategory, PatenData patenData, String instructionManual, String reviewReport) {
        this.activeIngredient = activeIngredient;
        this.activeIngredientEn = activeIngredientEn;
        this.drugName = drugName;
        this.drugNameEn = drugNameEn;
        this.productName = productName;
        this.productNameEn = productNameEn;
        this.formulation = formulation;
        this.routeOfAdministration = routeOfAdministration;
        this.specification = specification;
        this.referencePreparation = referencePreparation;
        this.standardPreparation = standardPreparation;
        this.TECode = TECode;
        this.ATCCode = ATCCode;
        this.approvalRegistrationNumber = approvalRegistrationNumber;
        this.approvalDate = approvalDate;
        this.listingLicenseHolder = listingLicenseHolder;
        this.manufacturer = manufacturer;
        this.listingStatus = listingStatus;
        this.inclusionCategory = inclusionCategory;
        this.patenData = patenData;
        this.instructionManual = instructionManual;
        this.reviewReport = reviewReport;
    }

    public DrukData() {
    }
}
