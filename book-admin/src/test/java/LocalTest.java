import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class LocalTest {

    private void formatData() throws ParseException {
//         SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd HHmmss");
//        Date parse = sdf.parse("240229 084799");
//        System.out.println(parse);
//
//        Calendar instance = Calendar.getInstance();
//        instance.setTime(new Date());
//        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
//        instance.add(Calendar.DATE,1);
//        String format1 = df.format(instance.getTime());
//        System.out.println(format1);
//        instance.add(Calendar.DATE,-1);
//        String format2 = df.format(instance.getTime());
//        System.out.println(format2);
        String str = "yyMMdd HHmmss yyMMdd HHmmss ";
        int ss = str.indexOf("ss");

        System.out.println(ss);

    }



}

