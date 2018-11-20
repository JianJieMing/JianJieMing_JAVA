package com.lanou3g.swagger2demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Huangqing
 * @date 2018/5/17 10:20
 */
@RestController
@Api(description = "测试Demo")
public class SwaggerController {

/*
    @Api：用在请求的类上，表示对类的说明
    tags= "说明该类的作用，可以在UI界面上看到的注解"
    value="该参数没什么意义，在UI界面上也看到，所以不需要配置"
    @ApiOperation：用在请求的方法上，说明方法的用途、作用
    value="说明方法的用途、作用"
    notes="方法的备注说明"
    @ApiImplicitParams：用在请求的方法上，表示一组参数说明
    @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
    name：参数名
    value：参数的汉字说明、解释
    required：参数是否必须传
    paramType：参数放在哪个地方
    · header --> 请求参数的获取：
    @RequestHeader· query --> 请求参数的获取：
    @RequestParam· path（用于restful接口）--> 请求参数的获取：
    @PathVariable· body（不常用）
    · form（不常用）
    dataType：参数类型，默认String，其它值dataType="Integer"
    defaultValue：参数的默认值
    @ApiResponses：用在请求的方法上，表示一组响应
    @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
    code：数字，例如400message：信息，例如"请求参数没填好"response：抛出异常的类
    @ApiModel：用于响应类上，表示一个返回响应数据的信息
    （这种一般用在post创建的时候，使用@RequestBody这样的场景，
    请求参数无法使用@ApiImplicitParam注解进行描述的时候）
    @ApiModelProperty：用在属性上，描述响应类的属

*/


    @ApiOperation(value = "你好Swagger", notes = "测试使用")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "string"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "string")
    })
    @PostMapping("/test")
    public String hello(String username, String password) {
        return "测试Demo";
    }
}
