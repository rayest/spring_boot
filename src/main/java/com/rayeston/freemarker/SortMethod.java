package com.rayeston.freemarker;

import freemarker.template.SimpleSequence;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

/**
 * Created by lirui on 2017/10/2.
 */
public class SortMethod implements TemplateMethodModelEx {
    @Override
    public Object exec(List arguments) throws TemplateModelException {
        SimpleSequence arg0 = (SimpleSequence) arguments.get(0);
        List<BigDecimal> list = arg0.toList();
        list.sort(Comparator.comparingInt(BigDecimal::intValue));
        return list;
    }
}
