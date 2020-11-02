package com.hung.ecoshop.config;

import com.hung.common.enums.DateTimeFormat;
import com.hung.common.utils.DateUtils;
import com.hung.common.utils.EnumUtils;
import com.hung.common.utils.StringUtils;
import com.hung.ecoshop.enums.CodeEnum;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.ConditionalConverter;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Configuration
public class ModelMapperConfig {

    @Bean
    protected ModelMapper modelMapper(){
        final ModelMapper modelMapper = new ModelMapper();
        final List<ConditionalConverter<?, ?>> converters = modelMapper.getConfiguration().getConverters();

        modelMapper.addConverter(convertStringToLocalDate());
        modelMapper.addConverter(convertLocalDateToString());
        modelMapper.addConverter(convertStringToTimeStamp());
        modelMapper.addConverter(convertTimeStampToString());
        modelMapper.addConverter(trimString());
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        converters.add(0, objectToEnumConverter());
        return modelMapper;
    }

    /**
     * String to LocalDate Converter
     *
     * @return AbstractConverter
     */
    private AbstractConverter<String, LocalDate> convertStringToLocalDate() {

        return new AbstractConverter<String, LocalDate>() {

            @Override
            protected LocalDate convert(final String source) {

                if(StringUtils.isEmpty(source)) {
                    return null;
                }
                return DateUtils.convertStringToLocalDate(source, DateTimeFormat.SLASH_YYYYMMDD);
            }
        };
    }

    /**
     * LocalDate to String Converter
     *
     * @return AbstractConverter
     */
    private AbstractConverter<LocalDate, String> convertLocalDateToString() {
        return new AbstractConverter<LocalDate, String>() {

            @Override
            protected String convert(final LocalDate source) {
                return DateUtils.convertDateToString(source, DateTimeFormat.SLASH_YYYYMMDD);
            }
        };
    }

    /**
     * String to Date Converter
     *
     * @return AbstractConverter
     */
    private AbstractConverter<String, Date> convertStringToTimeStamp() {
        return new AbstractConverter<String, Date>() {

            @Override
            protected Date convert(final String source) {

                if(StringUtils.isEmpty(source)) {
                    return null;
                }
                return DateUtils.convertStringToDate(source, DateTimeFormat.SLASH_YYYY_MM_DD_HH_MM_SS);
            }
        };
    }

    /**
     * String to Date Converter
     *
     * @return AbstractConverter
     */
    private AbstractConverter<Date, String> convertTimeStampToString() {
        return new AbstractConverter<Date, String>() {

            @Override
            protected String convert(final Date source) {

                if(source == null) {
                    return null;
                }
                return DateUtils.convertDateToString(source, DateTimeFormat.SLASH_YYYY_MM_DD_HH_MM_SS);
            }
        };
    }

    /**
     * Object to CodeEnum Converter
     *
     * @return ConditionalConverter
     */
    private ConditionalConverter<String, Enum<? extends CodeEnum>> objectToEnumConverter() {
        return new ConditionalConverter<String, Enum<? extends CodeEnum>>() {
            @SuppressWarnings({ "unchecked", "rawtypes" })
            public Enum<? extends CodeEnum> convert(
                    final MappingContext<String, Enum<? extends CodeEnum>> context) {

                final Object source = context.getSource();
                if (source == null) {
                    return null;
                }

                String value = null;
                if(source.getClass() == String.class) {

                    value =(String) source;
                }else {

                    value =((CodeEnum)source).getValue();
                }


                if (value != null) {
                    final Class clazz = context.getDestinationType();
                    return (Enum) EnumUtils.getEnum(clazz, value);

                }
                return null;
            }

            public MatchResult match(final Class<?> sourceType, final Class<?> destinationType) {

                MatchResult matchResult = MatchResult.NONE;

                if(destinationType.isEnum()&& sourceType == String.class) {
                    matchResult = MatchResult.FULL;
                }
                return matchResult;
            }
        };
    }

    private AbstractConverter<String, String> trimString(){
        return new AbstractConverter<String, String>() {
            @Override
            protected String convert(String s) {
                return StringUtils.trim(s);
            }
        };
    }
}
