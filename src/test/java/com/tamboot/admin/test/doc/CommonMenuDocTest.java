package com.tamboot.admin.test.doc;

import com.tamboot.restdocs.mockmvc.AsciidocConfig;
import com.tamboot.restdocs.mockmvc.TambootDocTest;
import org.junit.Test;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@AsciidocConfig(title = "个人菜单", orderIndex = 1)
@WithUserDetails
@Transactional
@Rollback
public class CommonMenuDocTest extends TambootDocTest {

    @Test
    @AsciidocConfig(title = "获取菜单树")
    public void tree() throws Exception {
        this.mockMvc
                .perform(getJson( "/common/menu/tree"))
                .andExpect(status().isOk())
                .andDo(document(
                        requestParameters(),
                        commonResponseFields(
                                fieldWithPath("data[]").type(JsonFieldType.ARRAY).description("数据").optional(),
                                fieldWithPath("data[].id").type(JsonFieldType.STRING).description("菜单ID").optional(),
                                fieldWithPath("data[].path").type(JsonFieldType.STRING).description("路径").optional(),
                                fieldWithPath("data[].name").type(JsonFieldType.STRING).description("名称").optional(),
                                fieldWithPath("data[].icon").type(JsonFieldType.STRING).description("图标").optional(),
                                fieldWithPath("data[].orderIndex").type(JsonFieldType.NUMBER).description("排序，从0开始，值小的排序靠前。").optional(),
                                fieldWithPath("data[].parent").type(JsonFieldType.STRING).description("父菜单ID").optional(),
                                fieldWithPath("data[].locale").type(JsonFieldType.STRING).description("语言类型，国际化时使用").optional(),
                                fieldWithPath("data[].children[]").type(JsonFieldType.ARRAY).description("子菜单列表").optional(),
                                fieldWithPath("data[].children[].*").type(JsonFieldType.VARIES).description("子菜单信息").optional()
                        ))
                );
    }
}
