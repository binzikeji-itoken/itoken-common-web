package com.binzikeji.itoken.common.web.components.datatables;

import com.binzikeji.itoken.common.dto.BaseRestult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Description
 * @Author Bin
 * @Date 2019/5/18 18:13
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class DataTablesResult extends BaseRestult implements Serializable{

    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private String error;
}
