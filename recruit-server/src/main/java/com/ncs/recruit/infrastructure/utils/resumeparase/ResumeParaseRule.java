package com.ncs.recruit.infrastructure.utils.resumeparase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ncs.recruit.context.resume.model.Resume;

public class ResumeParaseRule {

    private String workexperience;//工作经历
    private String birthOrAge;//出生日期或者年龄
    private String phone_code;//电话号码
    private String email;//邮箱
    private String idCard;//身份证信息

    /**
     * 基本字段解析：
     * name,idcard(身份证号)，gender（性别），birthday（出生日期或者年龄），origin_place(籍贯)，phone_num(电话号码或手机号)
     * email(邮箱)，work_year(工作年限)，station(期望岗位)，self_eval(自我评价)，residence（现居住地），exp_place(期望工作地)
     *
     * @param resumeFilePath
     * @return
     */
    public Resume rusmeParase4BaseField(String resumeFilePath) {
        Map<String, Integer> indexmap = new HashMap<String, Integer>();
        Map<String, String> resume_map = new HashMap<String, String>();
        try {
            //获取解析后的字符串
            String content = null;
			/*String baseMessage2=content.substring(content.length()-100);
			content=content.substring(0,350);
			StringBuffer baseMesBuffer=new StringBuffer(content);
			content=baseMesBuffer.append(baseMessage2).toString();*/
            if ("不支持该格式的文档".equals(content)) {
                resume_map.put("error", "不支持该格式的文档");
                return null;
            }
            if ("notExists".equals(content)) {
                resume_map.put("error", "文档不存在！");
                return null;
            }
            //获得字段的map集合
            indexmap = field_map(content);

            //获取工作经验字段
            if (workexperience != null && !"".equals(workexperience)) {
                Float workYear = Float.parseFloat(Validator.getWorkExpNum(workexperience));
                resume_map.put("workYear", workYear.toString());
            } else {
                //if workexperience==null ,将要从工作经历中去计算
                System.out.println("workexperience==null");
            }
            //获取身份证号字段
            if (idCard != null) {
                resume_map.put("idCard", idCard);
            }
            //获取出生日期字段
            if (birthOrAge != null) {
                resume_map.put("birthOrAge", birthOrAge);
            }
            //获取电话号码字段
            if (phone_code != null) {
                resume_map.put("phone_code", phone_code);
            }
            //获取邮箱字段
            if (email != null) {
                resume_map.put("email", email);
            }
            //获取性别字段
            if (indexmap.get("男") != -1) {
                resume_map.put("gender", "男");
            } else {
                resume_map.put("gender", "女");
            }

            int name_end = 200;
            //计算出距离指定关键字下标最近的一个关键字下标
            for (Map.Entry<String, Integer> entry : indexmap.entrySet()) {
                //获取姓名字段的最近下标
                if (entry.getValue() < name_end && !"姓名".equals(entry.getKey()) && !"".equals(entry.getKey())) {//筛选掉简历中没有的字段
                    name_end = entry.getValue();
                }
            }
            //筛选姓名
            //获取姓名字段的最近下标
            String name = null;
            int name_index = 0;
            int name_size = 0;
            if (indexmap.containsKey("姓名")) {
                name_index = indexmap.get("姓名");
                name_size = 3;
            }
            System.out.println("name_size:" + name_size + ",name_index:" + name_index);
            int name_sub_map_enty = 100;
            for (Map.Entry<String, Integer> entry : indexmap.entrySet()) {
                int name_sub1 = entry.getValue() - name_index;
                if (name_sub1 <= name_sub_map_enty && name_sub1 > 0)
                    name_sub_map_enty = name_sub1;
            }
            int[] name_indexArray = Validator.getSeparatorIndex(content);
            System.out.println("name_sub_map_enty:" + name_sub_map_enty);
            //如果简历中含有“|”
            if (name_indexArray != null && name_indexArray.length > 0) {
                boolean flag = false;
                for (int i = 0; i < name_indexArray.length; i++) {
                    int sub2 = name_indexArray[i] - name_index;
                    if (sub2 <= name_sub_map_enty && sub2 > 0) {
                        name_sub_map_enty = sub2;
                        flag = true;
                    }
                }
                if (flag) {
                    name = content.substring(name_index + name_size, name_index + name_sub_map_enty);
                } else {
                    name = content.substring(name_index + name_size + 1, name_index + name_sub_map_enty);

                }

            }
            name = content.substring(name_index + name_size, name_index + name_sub_map_enty);
            resume_map.put("name", name);
            System.out.println("姓名：" + name);
            //筛选籍贯或者是户口地
            //获取籍贯字段的最近下标
            String origin_place = null;
            if (indexmap.containsKey("户口") || indexmap.containsKey("户口/国籍") || indexmap.containsKey("籍贯") || indexmap.containsKey("家庭地址")) {
                int orig_place_index = 0;
                int orig_place_size = 0;
                if (indexmap.containsKey("户口")) {
                    orig_place_index = indexmap.get("户口");
                    orig_place_size = 2;
                }
                if (indexmap.containsKey("户口/国籍")) {
                    orig_place_index = indexmap.get("户口/国籍");
                    orig_place_size = 5;
                }
                if (indexmap.containsKey("籍贯")) {
                    orig_place_index = indexmap.get("籍贯");
                    orig_place_size = 2;
                }
                if (indexmap.containsKey("家庭地址")) {
                    orig_place_index = indexmap.get("家庭地址");
                    orig_place_size = 4;
                }
                System.out.println("orig_place_size:" + orig_place_size + ",orig_place_index:" + orig_place_index);
                int sub_map_enty = 100;
                for (Map.Entry<String, Integer> entry : indexmap.entrySet()) {
                    int sub1 = entry.getValue() - orig_place_index;
                    if (sub1 <= sub_map_enty && sub1 > 0)
                        sub_map_enty = sub1;
                }
                int[] indexArray = Validator.getSeparatorIndex(content);
                //如果简历中含有“|”
                if (indexArray != null && indexArray.length > 0) {
                    boolean flag = false;
                    for (int i = 0; i < indexArray.length; i++) {
                        int sub2 = indexArray[i] - orig_place_index;
                        if (sub2 <= sub_map_enty && sub2 > 0) {
                            sub_map_enty = sub2;
                            flag = true;
                        }
                    }
                    if (flag) {
                        origin_place = content.substring(orig_place_index + orig_place_size, orig_place_index + sub_map_enty);
                    } else {
                        origin_place = content.substring(orig_place_index + orig_place_size, orig_place_index + sub_map_enty);

                    }

                } else {
                    origin_place = content.substring(orig_place_index + orig_place_size + 1, orig_place_index + sub_map_enty);

                }
                resume_map.put("origin_place", origin_place);
                System.out.println("户籍地：" + origin_place);

            }
            //筛选现居住地
            //获取现居住地字段的最近下标
            String residence = null;
            if (indexmap.containsKey("现居住") || indexmap.containsKey("现住地址") || indexmap.containsKey("现居住于")) {
                int residence_index = 0;
                int residence_size = 0;
                if (indexmap.containsKey("现居住")) {
                    residence_index = indexmap.get("现居住");
                    residence_size = 3;
                }
                if (indexmap.containsKey("现住地址")) {
                    residence_index = indexmap.get("现住地址");
                    residence_size = 4;
                }
                if (indexmap.containsKey("现居住于")) {
                    residence_index = indexmap.get("现居住于");
                    residence_size = 5;
                }
                System.out.println("residence_size:" + residence_size + ",residence_index:" + residence_index);
                int sub_map_enty = 200;
                for (Map.Entry<String, Integer> entry : indexmap.entrySet()) {
                    int sub1 = entry.getValue() - residence_index;
                    if (sub1 <= sub_map_enty && sub1 > 0)
                        sub_map_enty = sub1;
                }
                int[] indexArray = Validator.getSeparatorIndex(content);
                //如果简历中含有“|”
                if (indexArray != null && indexArray.length > 0) {
                    boolean flag = false;
                    for (int i = 0; i < indexArray.length; i++) {
                        int sub2 = indexArray[i] - residence_index;
                        if (sub2 <= sub_map_enty && sub2 > 0) {
                            sub_map_enty = sub2;
                            flag = true;
                        }
                    }
                    if (flag) {
                        residence = content.substring(residence_index + residence_size - 1, residence_index + sub_map_enty);
                    } else {
                        residence = content.substring(residence_index + residence_size, residence_index + sub_map_enty - 1);

                    }

                } else {
                    residence = content.substring(residence_index + residence_size, residence_index + sub_map_enty - 1);

                }
                resume_map.put("residence", residence);
                System.out.println("现居住地：" + residence);

            }
            //筛选自我评价
            //获取自我评价字段的最近下标
            String self_eval = null;
            if (indexmap.containsKey("自我评价")) {
                int self_eval_index = 0;
                int self_eval_size = 0;
                if (indexmap.containsKey("自我评价")) {
                    self_eval_index = indexmap.get("自我评价");
                    self_eval_size = 4;
                }
                System.out.println("self_eval_size:" + self_eval_size + ",self_eval_index:" + self_eval_index);
                int sub_map_enty = 500;
                for (Map.Entry<String, Integer> entry : indexmap.entrySet()) {
                    int sub1 = entry.getValue() - self_eval_index;
                    if (sub1 <= sub_map_enty && sub1 > 0)
                        sub_map_enty = sub1;
                }
                int[] indexArray = Validator.getSeparatorIndex(content);
                //如果简历中含有“|”
                if (indexArray != null && indexArray.length > 0) {
                    for (int i = 0; i < indexArray.length; i++) {
                        int sub2 = indexArray[i] - self_eval_index;
                        if (sub2 <= sub_map_enty && sub2 > 0) {
                            sub_map_enty = sub2;
                        }
                    }

                }
                if (sub_map_enty == 500) {
                    self_eval = content.substring(self_eval_index + self_eval_size);
                } else {
                    self_eval = content.substring(self_eval_index + self_eval_size, self_eval_index + sub_map_enty - 1);
                }
                resume_map.put("self_eval", self_eval);
                System.out.println("自我评价：" + self_eval);

            }
            //期望工作地点
            //筛选现居住地
            //获取现居住地字段的最近下标
            String expPlace = null;
            if (indexmap.containsKey("地点") || indexmap.containsKey("工作地区")) {
                int expectWorkIn_index = 0;
                int expectWorkIn_size = 0;
                if (indexmap.containsKey("地点")) {
                    expectWorkIn_index = indexmap.get("地点");
                    expectWorkIn_size = 2;
                }
                if (indexmap.containsKey("工作地区")) {
                    expectWorkIn_index = indexmap.get("工作地区");
                    expectWorkIn_size = 4;
                }
                System.out.println("residence_size:" + expectWorkIn_size + ",residence_index:" + expectWorkIn_index);
                int sub_map_enty = 500;
                for (Map.Entry<String, Integer> entry : indexmap.entrySet()) {
                    int sub1 = entry.getValue() - expectWorkIn_index;
                    if (sub1 <= sub_map_enty && sub1 > 0)
                        sub_map_enty = sub1;
                }
                int[] indexArray = Validator.getSeparatorIndex(content);
                //如果简历中含有“|”
                if (indexArray != null && indexArray.length > 0) {
                    boolean flag = false;
                    for (int i = 0; i < indexArray.length; i++) {
                        int sub2 = indexArray[i] - expectWorkIn_index;
                        if (sub2 <= sub_map_enty && sub2 > 0) {
                            sub_map_enty = sub2;
                            flag = true;
                        }
                    }
                    if (flag) {
                        expPlace = content.substring(expectWorkIn_index + expectWorkIn_size - 1, expectWorkIn_index + sub_map_enty);
                    } else {
                        expPlace = content.substring(expectWorkIn_index + expectWorkIn_size, expectWorkIn_index + sub_map_enty - 1);

                    }

                } else {
                    expPlace = content.substring(expectWorkIn_index + expectWorkIn_size, expectWorkIn_index + sub_map_enty - 1);

                }
                resume_map.put("exp_place", expPlace);
                System.out.println("期望工作地：" + expPlace);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 关键字筛选： 通过关键字段对简历进行筛选，并放在map集合中
     *
     * @param content
     * @return
     */
    public Map<String, Integer> field_map(String content) {
        //截取内容中的基本信息段，一般按照150字符长度，减少遍历长度

        String baseMessage = content;
		/*String baseMessage=content.substring(0,350);
		String baseMessage2=content.substring(content.length()-100);
		StringBuffer baseMesBuffer=new StringBuffer(baseMessage);
		baseMessage=baseMesBuffer.append(baseMessage2).toString();*/
        System.out.println("全文==》" + content);
        /*System.out.println("基本信息段==》"+baseMessage);*/
        Map<String, Integer> indexmap = new HashMap<String, Integer>();
        int name_index = baseMessage.indexOf("姓名");
        if (name_index != -1) {

            indexmap.put("姓名", name_index);
        }

        int other1_index = baseMessage.indexOf("流程状态");
        if (other1_index != -1) {
            indexmap.put("流程状态", other1_index);
        }

        int other2_index = baseMessage.indexOf("目前");
        if (other2_index != -1) {
            indexmap.put("目前", other2_index);
        }

        int gender_index_start = baseMessage.indexOf("性别：");
        if (gender_index_start != -1) {
            indexmap.put("性别", gender_index_start);
        }
        int gender_index_m = baseMessage.indexOf("男");
        if (gender_index_m != -1) {
            indexmap.put("男", gender_index_m);
        }
        int gender_index_f = baseMessage.indexOf("女");
        if (gender_index_f != -1) {
            indexmap.put("女", gender_index_f);
        }

        int birth_index1 = baseMessage.indexOf("出生年月");
        if (birth_index1 != -1) {
            indexmap.put("出生年月", birth_index1);
        }
        int birth_index2 = baseMessage.indexOf("出生日期");
        if (birth_index2 != -1) {
            indexmap.put("出生日期", birth_index2);
        }
        birthOrAge = Validator.getbirth(baseMessage);
        int birth_index3 = baseMessage.indexOf(birthOrAge);
        if (birth_index3 != -1) {
            indexmap.put(birthOrAge, birth_index3);
        }
        //System.out.println(birthOrAge);

        int phone_index1 = baseMessage.indexOf("手机");
        if (phone_index1 != -1) {
            indexmap.put("手机", phone_index1);
        }
        int phone_index2 = baseMessage.indexOf("电话");
        if (phone_index2 != -1) {
            indexmap.put("电话", phone_index2);
        }
        phone_code = Validator.getTelnum(baseMessage);
        int phone_index3 = baseMessage.indexOf(phone_code);
        if (phone_index3 != -1) {
            indexmap.put(phone_code, phone_index3);
        }
        //为避免有些简历的电话号码与邮箱号码紧挨着，在正则匹配邮箱时会出现电话号码与邮箱匹配在一起的问题
        //解决办法：解析完成电话号码后,在电话号码后面加上一个区分符号“,”
        if (phone_code.length() > 0 && phone_index3 != -1) {
            int insert_index = phone_index3 + phone_code.length();
            String content2 = baseMessage.substring(0, insert_index);
            StringBuffer contentBuffer = new StringBuffer(content2);
            contentBuffer.append(",");
            String content3 = baseMessage.substring(insert_index);
            contentBuffer.append(content3);
            baseMessage = contentBuffer.toString();
        }

        int email_index1 = baseMessage.indexOf("邮箱");
        if (email_index1 != -1) {
            indexmap.put("邮箱", email_index1);
        }
        int email_index2 = baseMessage.indexOf("E-mail");
        if (email_index2 != -1) {
            indexmap.put("E-mail", email_index2);
        }
        email = Validator.getEmail(baseMessage);
        int email_index3 = baseMessage.indexOf(email);
        if (email_index3 != -1) {
            indexmap.put(email, email_index3);
        }

        //工作年限
        workexperience = Validator.getWorkExprice(baseMessage);
        if (workexperience != null && !"".equals(workexperience)) {
            int wp_index1 = baseMessage.indexOf(workexperience);
            indexmap.put(workexperience, wp_index1);
			/*String workYear=Validator.getWorkExpNum(workexperience);
			//提取简历中含有重复的“工作经验”，用于区分该关键词
			baseMessage=baseMessage.replace(workexperience, workYear+"年工作年限");
			//在此区分
			int work_express_index1=baseMessage.indexOf("工作经验");
			if(work_express_index1!=-1){
				if(Validator.isInteger(work_String)){
					indexmap.put("工作经验", work_express_index1);
				}
			}*/
        }
        //身份证信息
        int idCard_index1 = baseMessage.indexOf("身份证");
        if (idCard_index1 != -1) {
            indexmap.put("身份证", idCard_index1);
        }
        idCard = Validator.getIdCard(baseMessage);
        if (idCard != null && !" ".equals(idCard)) {
            int idCard_index = baseMessage.indexOf(idCard);
            indexmap.put(idCard, idCard_index);
        }
        //身高信息，还未进行解析，只是作为分隔关键字，用于分隔其他信息
        int height_index1 = baseMessage.indexOf("身高");
        if (height_index1 != -1) {
            indexmap.put("身高", height_index1);
        }
        //婚姻状况，还未进行解析，只是作为分隔关键字，用于分隔其他信息
        int marital_status_index1 = baseMessage.indexOf("婚姻状况");
        if (marital_status_index1 != -1) {
            indexmap.put("婚姻状况", marital_status_index1);
        }
        //籍贯或者是户口所在地
        int originPlace_index1 = baseMessage.indexOf("户口");
        if (originPlace_index1 != -1) {
            indexmap.put("户口", originPlace_index1);
        }
        int originPlace_index2 = baseMessage.indexOf("户口/国籍");
        if (originPlace_index2 != -1) {
            indexmap.put("户口/国籍", originPlace_index2);
        }
        System.out.println("籍贯：----" + baseMessage);
        int originPlace_index3 = baseMessage.indexOf("籍贯");
        if (originPlace_index3 != -1) {
            indexmap.put("籍贯", originPlace_index3);
        }
        int originPlace_index4 = baseMessage.indexOf("家庭地址");
        if (originPlace_index4 != -1) {
            indexmap.put("家庭地址", originPlace_index4);
        }
        //现居住地，
        int residence_index1 = baseMessage.indexOf("现居住");
        if (residence_index1 != -1) {
            indexmap.put("现居住", residence_index1);
        }
        int residence_index2 = baseMessage.indexOf("现居住于");
        if (residence_index2 != -1) {
            indexmap.put("现居住于", residence_index2);
        }
        int residence_index3 = baseMessage.indexOf("现住地址");
        if (residence_index3 != -1) {
            indexmap.put("现住地址", residence_index3);
        }

        //求职意向
        int job_intension_index1 = baseMessage.indexOf("求职意向");
        if (job_intension_index1 != -1) {
            indexmap.put("求职意向", job_intension_index1);
        }
        int politics_status_index1 = baseMessage.indexOf("政治面貌");
        if (politics_status_index1 != -1) {
            indexmap.put("政治面貌", politics_status_index1);
        }
        int self_eval_index1 = baseMessage.indexOf("自我评价");
        if (self_eval_index1 != -1) {
            indexmap.put("自我评价", self_eval_index1);
        }
        //期望工作地
        int expectWorkIn_index1 = baseMessage.indexOf("地点");
        if (expectWorkIn_index1 != -1) {
            indexmap.put("地点", expectWorkIn_index1);
        }
        int expectWorkIn_index2 = baseMessage.indexOf("工作地区");
        if (expectWorkIn_index2 != -1) {
            indexmap.put("工作地区", expectWorkIn_index2);
        }
        int expectMonthlySalaryIndex1 = baseMessage.indexOf("期望月薪");
        if (expectMonthlySalaryIndex1 != -1) {
            indexmap.put("期望月薪", expectMonthlySalaryIndex1);
        }
        int functionIndex1 = baseMessage.indexOf("职能");
        if (functionIndex1 != -1) {
            indexmap.put("职能", functionIndex1);
        }

        //详情关键字的定位
        List<String> detailKeyList = new ArrayList<String>();
        detailKeyList = Validator.getDetailKeywords4Resume(baseMessage);
        for (String string : detailKeyList) {
            int keyIndex = baseMessage.indexOf(string);
            indexmap.put(string, keyIndex);
        }
        return indexmap;

    }

}
