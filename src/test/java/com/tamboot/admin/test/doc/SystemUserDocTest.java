package com.tamboot.admin.test.doc;

import com.tamboot.restdocs.mockmvc.AsciidocConfig;
import com.tamboot.restdocs.mockmvc.TambootDocTest;
import org.junit.Test;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.security.test.context.support.WithUserDetails;

@AsciidocConfig(title = "用户管理", orderIndex = 3)
@WithUserDetails(value = "admin")
public class SystemUserDocTest extends TambootDocTest {

    @Test
    @AsciidocConfig(title = "用户分页", orderIndex = 1)
    public void page() throws Exception {
        this.mockMvc.perform(getJson( "/system/user/page")
                .param("pageNum", "1")
                .param("pageSize", "20")
        )
        .andExpect(status().isOk())
        .andDo(document(
                requestParameters(
                        parameterWithName("pageNum").description("页码").optional(),
                        parameterWithName("pageSize").description("分页大小").optional(),
                        parameterWithName("usernameLike").description("用户名，支持模糊查询。").optional(),
                        parameterWithName("status").description("用户状态").optional(),
                        parameterWithName("roleCode").description("拥有的角色编码").optional()
                ),
                commonResponseFields(
                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("数据"),
                        fieldWithPath("data.pageNum").type(JsonFieldType.NUMBER).description("页码"),
                        fieldWithPath("data.pageSize").type(JsonFieldType.NUMBER).description("分页大小"),
                        fieldWithPath("data.total").type(JsonFieldType.NUMBER).description("总记录数"),
                        fieldWithPath("data.pages").type(JsonFieldType.NUMBER).description("总页数"),
                        fieldWithPath("data.result[]").type(JsonFieldType.ARRAY).description("当前页记录数").optional(),
                        fieldWithPath("data.result[].id").type(JsonFieldType.STRING).description("用户id"),
                        fieldWithPath("data.result[].username").type(JsonFieldType.STRING).description("用户名"),
                        fieldWithPath("data.result[].status").type(JsonFieldType.NUMBER).description("状态"),
                        fieldWithPath("data.result[].roleCodeList[]").type(JsonFieldType.ARRAY).description("所有的角色编码"),
                        fieldWithPath("data.result[].roleNameList[]").type(JsonFieldType.ARRAY).description("所有的角色名称"),
                        fieldWithPath("data.result[].roleCodes").type(JsonFieldType.STRING).description("所有的角色编码，以逗号分隔。").optional(),
                        fieldWithPath("data.result[].roleNames").type(JsonFieldType.STRING).description("所有的角色名称，以逗号分隔。").optional()
                ))
        );
    }

    @Test
    @AsciidocConfig(title = "启用用户", orderIndex = 2, snippets = AsciidocConfig.PATH_PARAMS_SNIPPETS)
    public void enable() throws Exception {
        this.mockMvc
                .perform(postJson("/system/user/enable/{userId}", null, 2))
                .andExpect(status().isOk())
                .andDo(document(
                        pathParameters(
                                parameterWithName("userId").description("用户id")
                        ),
                        commonResponseFields(
                                fieldWithPath("data").ignored().optional()
                        ))
                );
    }
}
