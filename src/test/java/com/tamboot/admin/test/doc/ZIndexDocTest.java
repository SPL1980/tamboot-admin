package com.tamboot.admin.test.doc;

import com.tamboot.admin.constants.UserStatus;
import com.tamboot.restdocs.mockmvc.AsciidocConfig;
import com.tamboot.restdocs.mockmvc.AsciidocGenerator;
import com.tamboot.restdocs.mockmvc.TambootDocTest;
import com.tamboot.webapp.web.ResponseType;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@AsciidocConfig(ignore = true)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ZIndexDocTest extends TambootDocTest {

    @Test
    public void zIndex() {
        AsciidocGenerator.createIndexDoc(this.context, getClass().getPackage().getName(), this.asciidocPath);
    }

    @Test
    public void dictionary() {
        AsciidocGenerator.createDictionaryDoc(this.asciidocPath,
                dictionaryItem(ResponseType.class, "接口返回码"),
                dictionaryItem(UserStatus.class, "用户状态")
        );
    }
}
