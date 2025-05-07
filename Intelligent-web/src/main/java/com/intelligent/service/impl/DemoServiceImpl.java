package com.intelligent.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.intelligent.CommonService;
import com.intelligent.TransionalService;
import com.intelligent.basic.result.ResponseMessage;
import com.intelligent.basic.result.Result;
import com.intelligent.dao.TestMapper;
import com.intelligent.dao.UserInfoMapper;
import com.intelligent.entity.Test;
import com.intelligent.entity.UserInfo;
import com.intelligent.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DemoServiceImpl implements DemoService {

    final TestMapper testMapper;
    final CommonService service;
    final TransionalService transionalService;
    final UserInfoMapper userInfoMapper;

    public ResponseMessage save() {
        Test test = new Test();
        test.setId("17526032399226716175");
        test.setName("fred");
        test.setAge(28);
        transionalService.dataProcessing(test);
        return Result.success("success");
    }

    public ResponseMessage get() {
        List<String> info =  Arrays.asList("id",
                "code",
                "create_by",
                "create_date",
                "update_by",
                "update_date",
                "description",
                "material_group",
                "month",
                "default_supplier",
                "listing_date",
                "shoe_last_no",
                "txture_thk",
                "closs_date_sale ",
                "fabric",
                "mou_category",
                "size_kind",
                "ean",
                "upc",
                "plant_id",
                "designer_no",
                "designer_name",
                "developer_no",
                "developer_name",
                "trsfr_no",
                "trsfr_name",
                "bottr_no",
                "bottr_name",
                "buyer_no",
                "buyer_name",
                "industry_standard",
                "safety_category",
                "shell_fabric",
                "fur_collar",
                "lining2",
                "stuffing",
                "cashmere_charge",
                "product_grade",
                "product_manager_no",
                "product_manager_name",
                "shoes_type",
                "remarks",
                "tenant",
                "mdt_product_category_id",
                "parent_id",
                "product_category_code",
                "plant_code",
                "name",
                "status",
                "update_flag",
                "rd_base",
                "material_type",
                "product_group",
                "weight_unit",
                "volume_unit",
                "year",
                "season",
                "brand",
                "series",
                "design_style",
                "element",
                "function",
                "size_type",
                "hardness",
                "testure",
                "testure_bottom",
                "lining1",
                "sole_craft",
                "head_type",
                "bottom_type",
                "heel",
                "height_bottom",
                "waterproof",
                "height_boot",
                "wearing",
                "pro_devl_no",
                "heel_craft",
                "upper",
                "product_role",
                "wave_picking",
                "num_segment",
                "area",
                "unit",
                "maintenance_mode",
                "customer_group",
                "size_unit",
                "material_type_group",
                "color_no",
                "color_name",
                "size_no",
                "size_name",
                "height",
                "length",
                "width",
                "total_weight",
                "net_weight",
                "volume",
                "mdt_product_category_code01",
                "product_category_name01",
                "color_set",
                "size_set",
                "mdt_product_category_code02",
                "mdt_product_category_name02",
                "mdt_product_category_code03",
                "mdt_product_category_name03",
                "spu_sku",
                "spu_code",
                "image",
                "is_have_stock");
        for (String str : info) {
            System.out.println("{\n" +
                    "\t\"name\": \""+str+"\",\n" +
                    "\t\"type\": \"string\"\n" +
                    "},");
        }
        return Result.success("success");
    }

    public Test buildTest () {
        UserInfo userInfo1 = userInfoMapper.selectByPrimaryKey("111");
        Test test = new Test();
        test.setId(IdWorker.getIdStr());
        test.setName(userInfo1.getUsername());
        return test;
    }


    public static void main(String[] args) {
        List<String> info =  Arrays.asList(
                "id",
                "sys_code",
                "member_id",
                "points_type",
                "order_no",
                "sub_order_no",
                "out_refer_no",
                "refer_no",
                "points_rule",
                "terminal_id",
                "channel_code",
                "merchant_code",
                "store_code",
                "pay_currency",
                "pay_amount",
                "direction_opt",
                "points",
                "actual_points",
                "value_date",
                "maturity_date",
                "transaction_time",
                "send_time",
                "remark",
                "transaction_type",
                "transaction_des",
                "status",
                "freeze_status",
                "clean_date",
                "batch_no",
                "voucher_codes",
                "ex_rate",
                "errorcode",
                "errormsg",
                "adj_identify",
                "orgi_order_no",
                "orgi_sub_order_no",
                "orginal_order_no",
                "orgi_freezed_refer_no",
                "created_by",
                "date_created",
                "date_updated",
                "is_deleted",
                "opt_counter",
                "tx_ref1",
                "updated_by",
                "sku_id"
        );
        for (String str : info) {
            System.out.println("{\n" +
                    "\t\"name\": \""+str+"\",\n" +
                    "\t\"type\": \"string\"\n" +
                    "},");
        }
    }

}
