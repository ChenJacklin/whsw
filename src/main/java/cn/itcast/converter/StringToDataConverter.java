package cn.itcast.converter;


import org.springframework.core.convert.converter.Converter;//注意不要导错包！！！
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
  自定义类型转换器，
  1. 自动把请求的日期字符串转换为Date日期类型
  2. 实现Converter<请求的数据类型，要转换的目标类型>*/

@Component()//创建对象并指定其对象名，加入IOC容器！！！
public class StringToDataConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        try {
            if(StringUtils.isEmpty(source)){//调用字符串工具类的静态方法，对传入的日期字符串进行非空判断
                return null;
            }
            //把日期字符串解析为Date日期对象！！！
            return new SimpleDateFormat("yyyy-MM-dd").parse(source);//把传入的
        } catch (ParseException e) {
           throw  new RuntimeException(e);
        }
    }
}
