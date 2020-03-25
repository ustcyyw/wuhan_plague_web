package com.ustcyyw.Controller;

import com.ustcyyw.Service.DetailedInfoServiceInterface;
import com.ustcyyw.vo.input.DetailedPlaguePointVo;
import com.ustcyyw.vo.input.DetailedTimeAtVo;
import com.ustcyyw.vo.input.DetailedTimeBetweenVo;
import com.ustcyyw.vo.output.DetailedInfoVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Time : 2020年1月28日22:17:32
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 各省区疫情信息Controller
 */
@RestController
@RequestMapping(path = "/detail")
public class DetailedInfoController extends BaseController {
    @Autowired
    private DetailedInfoServiceInterface detailedInfoService;

    @ApiOperation(value = "查询某时刻指定省区疫情信息接口，可选查询何类人数（默认为4种全部）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "theTime", value = "指定时刻", required = false, dataType = "String"),
            @ApiImplicitParam(name = "givenType", value = "指定何类人", required = false, dataType = "String"),
            @ApiImplicitParam(name = "province", value = "指定省区", required = true, dataType = "String")
    })
    @GetMapping(value = "/timeAt")
    public Map<String, Object> getRecordingAt(@Validated DetailedTimeAtVo vo, BindingResult br) {
        if (br.hasErrors()) {
            return writeResult(99999, br.getAllErrors());
        }
        DetailedInfoVo result = null;
        if (vo.getGivenType() == null)
            result = detailedInfoService.getFourTypeNumAtInProvince(vo.getTheTime(), vo.getProvince());
        else
            result = detailedInfoService.getGivenTypeNumAtInProvince(vo.getTheTime(), vo.getGivenType(), vo.getProvince());
        if (result == null)
            return writeResult(40001, null);
        return writeResult(0, result);
    }

    @ApiOperation(value = "查询某时刻指定省区疫情信息接口，可选查询何类人数（默认为4种全部）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "start", value = "指定开始时刻", required = false, dataType = "String"),
            @ApiImplicitParam(name = "end", value = "指定结束时刻", required = false, dataType = "String"),
            @ApiImplicitParam(name = "givenType", value = "指定何类人", required = false, dataType = "String"),
            @ApiImplicitParam(name = "province", value = "指定省区", required = true, dataType = "String")
    })
    @GetMapping(value = "/timeBetween")
    public Map<String, Object> getRecordingBetween(@Validated DetailedTimeBetweenVo vo, BindingResult br) {
        if (br.hasErrors()) {
            return writeResult(99999, br.getAllErrors());
        }
        List<DetailedInfoVo> result = null;
        if (vo.getGivenType() == null)
            result = detailedInfoService.getFourTypeNumBetweenInProvince(vo.getStart(), vo.getEnd(), vo.getProvince());
        else
            result = detailedInfoService.getGivenTypeNumBetweenInProvince(vo.getStart(), vo.getEnd(), vo.getGivenType(), vo.getProvince());
        if (result == null)
            return writeResult(40001, null);
        return writeResult(0, result);
    }

    @ApiOperation(value = "查询某时刻全国各省区疫情数值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "theTime", value = "指定时刻", required = false, dataType = "String")
    })
    @GetMapping(value = "/point")
    public Map<String, Object> getPlaguePoint(@Validated DetailedPlaguePointVo vo, BindingResult br) {
        if (br.hasErrors()) {
            return writeResult(99999, br.getAllErrors());
        }
        Map<String, Long> result = detailedInfoService.getProvincePlaguePoint(vo.getTheTime());
        if (result == null)
            return writeResult(40001, null);
        return writeResult(0, result);
    }
}
