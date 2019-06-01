package com.binzikeji.itoken.common.web.controller;

import com.binzikeji.itoken.common.domain.BaseDomain;
import com.binzikeji.itoken.common.utils.MapperUtils;
import com.binzikeji.itoken.common.web.components.datatables.DataTablesResult;
import com.binzikeji.itoken.common.web.service.BaseClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Chundekepa
 * @create: 2019-03-12 22:09
 **/
public abstract class BaseController<T extends BaseDomain, S extends BaseClientService> {

    @Autowired
    protected S s;

    /**
     * 分页查询
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public DataTablesResult page(HttpServletRequest request){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String setLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = setLength == null ? 0 : Integer.parseInt(setLength);

        String json = s.page(start,length,null);
        DataTablesResult dataTablesResult = null;
        try {
            dataTablesResult = MapperUtils.json2pojo(json, DataTablesResult.class);
            dataTablesResult.setDraw(draw);
            dataTablesResult.setRecordsTotal(dataTablesResult.getCursor().getTotal());
            dataTablesResult.setRecordsFiltered(dataTablesResult.getCursor().getTotal());
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataTablesResult;
    }
}
