package spring.core.annotation.annotationConfig;

import java.math.BigDecimal;
import java.text.NumberFormat;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class _6_JavaGenericsAsAutowiringQualifiers {

    @Bean
    RateFormatter<Integer> integerRateFormatter() {
        return new RateFormatter<Integer>();
    }

    @Bean
    RateFormatter<BigDecimal> bigDecimalRateFormatter() {
        return new RateFormatter<BigDecimal>();
    }

    @Bean
    RateCalculator rateCalculator() {
        return new RateCalculator();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(_6_JavaGenericsAsAutowiringQualifiers.class);
        RateCalculator bean = context.getBean(RateCalculator.class);
        bean.calculate();
    }
    
    public class RateCalculator {

        @Autowired
        private RateFormatter<BigDecimal> formatter;

        public void calculate() {
            BigDecimal rate = new BigDecimal(1053.75356);
            System.out.println(formatter.format(rate));
        }
    }
    

public class RateFormatter<T extends Number> {

    public String format(T number){
        NumberFormat format = NumberFormat.getInstance();
        if(number instanceof Integer){
            format.setMinimumIntegerDigits(0);
        }else if(number instanceof BigDecimal){
            format.setMinimumIntegerDigits(2);
            format.setMaximumFractionDigits(2);
        }//others

        return format.format(number);
    }
}
}
