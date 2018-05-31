package com.netpet.spools.spring.ioc.core;

import com.netpet.spools.spring.ioc.bean.BeanDefinition;
import com.netpet.spools.spring.ioc.bean.ConstructorArg;
import com.netpet.spools.spring.ioc.utils.BeanUtils;
import com.netpet.spools.spring.ioc.utils.ClassUtils;
import com.netpet.spools.spring.ioc.utils.ReflectionUtils;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactoryImpl implements BeanFactory {

    private static final ConcurrentHashMap<String, Object> beanMap = new ConcurrentHashMap<>();

    private static final ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private static final Set<String> beanNameSet = Collections.synchronizedSet(new HashSet<>());

    @Override
    public Object getBean(String name) throws Exception {
        Object bean = beanMap.get(name);
        if (bean != null) {
            return bean;
        }

        bean = createBean(beanDefinitionMap.get(name));
        if (bean != null) {
            populateBean(bean);
            beanMap.put(name, bean);
        }

        return bean;
    }

    protected Object createBean(BeanDefinition beanDefinition) throws Exception {
        String className = beanDefinition.getClassName();
        Class clz = ClassUtils.loadClass(className);
        if (clz == null) {
            throw new Exception("could not find bean by className" + ", className=" + className);
        }
        List<ConstructorArg> constructorArgs = beanDefinition.getConstructorArgs();
        if (constructorArgs != null && !constructorArgs.isEmpty()) {
            List<Object> objects = new ArrayList<>();
            for (ConstructorArg constructorArg : constructorArgs) {
                objects.add(getBean(constructorArg.getRef()));
            }
            return BeanUtils.instanceByCglib(clz, clz.getConstructor(), objects.toArray());
        }
        return BeanUtils.instanceByCglib(clz, null, null);
    }

    /**
     * 给对应属性注入bean
     * @param bean
     * @throws Exception
     */
    protected void populateBean(Object bean) throws Exception {
        Field[] fields = bean.getClass().getSuperclass().getDeclaredFields();
        if (fields != null && fields.length > 0) {
            for (Field field : fields) {
                String beanName = field.getName();
                beanName = StringUtils.uncapitalize(beanName);
                if (beanNameSet.contains(field.getName())) {
                    Object fieldBean = getBean(beanName);
                    if (fieldBean != null) {
                        ReflectionUtils.injectField(field, bean, fieldBean);
                    }
                }
            }
        }
    }

    protected void registerBean(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
        beanNameSet.add(name);
    }
}
