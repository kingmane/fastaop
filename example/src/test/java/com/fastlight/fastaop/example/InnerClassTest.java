package com.fastlight.fastaop.example;

import org.fastlight.aop.annotation.FastAspect;
import org.fastlight.aop.annotation.FastAspectVar;
import org.fastlight.aop.model.FastAspectContext;
import org.junit.Assert;
import org.junit.Test;

/**
 * 内部类测试，含静态内部类，和动态内部类
 *
 * @author ychost@outlook.com
 * @date 2021-03-29
 */
@FastAspect
public class InnerClassTest {
    @Test
    public void test() {
        @FastAspectVar FastAspectContext ctx = FastAspectContext.currentContext();
        Assert.assertNotNull(ctx);
        Assert.assertEquals(ctx.getMetaMethod().getMetaOwner().getType(), InnerClassTest.class);
        new InnerStatic().test();
        new InnerDynamic().test();
    }

    @FastAspect
    public static class InnerStatic {
        public void test() {
            @FastAspectVar FastAspectContext ctx = FastAspectContext.currentContext();
            Assert.assertNotNull(ctx);
            Assert.assertEquals(ctx.getMetaMethod().getMetaOwner().getType(), InnerStatic.class);
        }
    }

    @FastAspect
    public class InnerDynamic {
        public void test() {
            @FastAspectVar FastAspectContext ctx = FastAspectContext.currentContext();
            Assert.assertNotNull(ctx);
            Assert.assertEquals(ctx.getMetaMethod().getMetaOwner().getType(), InnerDynamic.class);
        }
    }
}
