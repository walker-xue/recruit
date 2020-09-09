package com.ncs.recruit.infrastructure.enums;

public enum EnumChinese {

    // 文件导出 中英文转换 （职位）
    HOUDUAN("houduan", "后端"), QIANDUAN("qianduan", "前段"), CHESHI("cheshi", "测试"),
    UI("uishejishi", "UI设计"), STATION1("station1", "java开发"), STATION2("station2", ".net(C#)开发 "),
    STATION3("station3", "Python开发 "), STATION4("station4", "PHP开发"),
    STATION5("station5", "C/C++开发"), STATION6("station6", "前端开发"), STATION7("station7", "功能测试 "),
    STATION8("station8", "自动化测试"), STATION9("station9", "无线测试"), STATION10("station10", "web测试"),
    STATION11("station11", "App测试"), STATION12("station12", "技术支持"),
    STATION13("station13", "设计师-交互"), STATION14("station14", "设计师-视觉"),
    STATION15("station15", "文档工程师"), STATION16("station16", "架构师"), STATION17("station17", "产品经理"),
    STATION18("station18", "需求分析师"), STATION19("station19", "项目经理"),
    // 文件导出 中英文转换 （业务线 ）
    ZHONGXING("zhongxing", "中兴"), TENXUN("tenxun", "腾讯"), ALI("ali", "阿里"), HUAWEI("huawei", "华为"),
    BUSILINE1("busiLine1", "北京阿里"), BUSILINE2("busiLine2", "上海阿里"), BUSILINE3("busiLine3", "解决方案"),
    BUSILINE4("busiLine4", "UED"), BUSILINE5("busiLine5", "互联网金融"), BUSILINE6("busiLine6", "企业服务"),
    BUSILINE7("busiLine7", "创新服务"), BUSILINE8("busiLine8", "新技术保障 "),
    // "招聘顾问","发布需求人" 资源经理 交付经理
    DeliveryManager("DeliveryManager", "交付经理"),
    RecruitmentConsultant("RecruitmentConsultant", "招聘顾问");

    private EnumChinese(String field, String name) {
        this.field = field;
        this.name = name;
    }

    private String field;
    private String name;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
