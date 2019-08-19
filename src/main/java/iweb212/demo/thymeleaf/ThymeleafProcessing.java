package iweb212.demo.thymeleaf;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.util.Arrays;


public class ThymeleafProcessing {
    public static void main(String[] args) {
        //1.创建模板解析器
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);

        //2.创建模板引擎
        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);

        //3.提供模板数据的存储环境
        Context context = new Context();
        context.setVariable("title","动态标题");
        context.setVariable("names",
                Arrays.asList("张三","李四","王五","赵柳","天启"));

       // 4.处理模板，生成HTML文件
        String html = engine.process("home",context);
        System.out.println(html);
    }
}
