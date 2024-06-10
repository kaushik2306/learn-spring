package dev.kc.learnspring.initialization;

import dev.kc.learnspring.beans.RecentTimepassBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
//import java.security.AccessController;
//import java.security.PrivilegedAction;
//import java.util.Collections;
//import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private static final Logger log = LoggerFactory.getLogger(CustomBeanFactoryPostProcessor.class);

    private static final String ANNOTATION_METHOD = "annotationData";

    private static final String ANNOTATIONS = "annotations";

//    private static final Constructor<?> AnnotationInvocationHandler_constructor;
//    private static final Constructor<?> AnnotationData_constructor;
//    private static final Method Class_annotationData;
//    private static final Field Class_classRedefinedCount;
//    private static final Field AnnotationData_annotations;
//    private static final Field AnnotationData_declaredAnotations;
//    private static final Method Atomic_casAnnotationData;
//    private static final Class<?> Atomic_class;

//    static{
//        // static initialization of necessary reflection Objects
//        try {
//            Class<?> AnnotationInvocationHandler_class = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
//            AnnotationInvocationHandler_constructor = AnnotationInvocationHandler_class.getDeclaredConstructor(new Class[]{Class.class, Map.class});
//            AnnotationInvocationHandler_constructor.setAccessible(true);
//
//            Atomic_class = Class.forName("java.lang.Class$Atomic");
//            Class<?> AnnotationData_class = Class.forName("java.lang.Class$AnnotationData");
//
//            AnnotationData_constructor = AnnotationData_class.getDeclaredConstructor(new Class[]{Map.class, Map.class, int.class});
//            AnnotationData_constructor.setAccessible(true);
//            Class_annotationData = Class.class.getDeclaredMethod("annotationData");
//            Class_annotationData.setAccessible(true);
//
//            Class_classRedefinedCount= Class.class.getDeclaredField("classRedefinedCount");
//            Class_classRedefinedCount.setAccessible(true);
//
//            AnnotationData_annotations = AnnotationData_class.getDeclaredField("annotations");
//            AnnotationData_annotations.setAccessible(true);
//            AnnotationData_declaredAnotations = AnnotationData_class.getDeclaredField("declaredAnnotations");
//            AnnotationData_declaredAnotations.setAccessible(true);
//
//            Atomic_casAnnotationData = Atomic_class.getDeclaredMethod("casAnnotationData", Class.class, AnnotationData_class, AnnotationData_class);
//            Atomic_casAnnotationData.setAccessible(true);
//
//        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | NoSuchFieldException e) {
//            throw new IllegalStateException(e);
//        }
//    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("{} is a BeanFactoryPostProcessor",getClass().getSimpleName());

        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames){
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
            String beanClassName = beanDefinition.getBeanClassName();
            if (beanClassName != null && beanClassName.equalsIgnoreCase(RecentTimepassBean.class.getName())){
                beanDefinition.setPrimary(true);
//                log.info("FOUND THE RECENT BEAN");
//
//                try {
//                    Class<?> beanClass = Class.forName(beanClassName);
//
//                    Primary newAnnotation = new Primary(){
//
//                        @Override
//                        public Class<? extends Annotation> annotationType() {
//                            return Primary.class;
//                        }
//                    };
//
//                    //putAnnotation(beanClass, Primary.class,newAnnotation);
//
//                    replaceAnnotation(beanClass, Primary.class,newAnnotation);
//
//
//
//                }catch (Exception e){
//                    e.printStackTrace();
//                }

            }else{
                continue;
            }

        }


//        PropertySourcesPlaceholderConfigurer cfg = new PropertySourcesPlaceholderConfigurer();
//        cfg.setLocation(new FileSystemResource("tapp.properties"));
//        Properties properties = new Properties();
//        cfg.setIgnoreUnresolvablePlaceholders(true);
//        properties.put("kc.name","run-time via bpp");
//        cfg.setProperties(properties);
//        System.setProperty("kc.name","spring");
//        cfg.postProcessBeanFactory(beanFactory);
    }


//    public static <T extends Annotation> void putAnnotation(Class<?> c, Class<T> annotationClass, Map<String, Object> valuesMap){
//        putAnnotation(c, annotationClass, annotationForMap(annotationClass, valuesMap));
//    }

//    public static <T extends Annotation> void putAnnotation(Class<?> c, Class<T> annotationClass, T annotation){
//        try {
//            while (true) { // retry loop
//                int classRedefinedCount = Class_classRedefinedCount.getInt(c);
//                Object /*AnnotationData*/ annotationData = Class_annotationData.invoke(c);
//                // null or stale annotationData -> optimistically create new instance
//                Object newAnnotationData = createAnnotationData(c, annotationData, annotationClass, annotation, classRedefinedCount);
//                // try to install it
//                if ((boolean) Atomic_casAnnotationData.invoke(Atomic_class, c, annotationData, newAnnotationData)) {
//                    // successfully installed new AnnotationData
//                    break;
//                }
//            }
//        } catch(IllegalArgumentException | IllegalAccessException | InvocationTargetException | InstantiationException e){
//            throw new IllegalStateException(e);
//        }
//
//    }

//    @SuppressWarnings("unchecked")
//    private static <T extends Annotation> Object /*AnnotationData*/ createAnnotationData(Class<?> c, Object /*AnnotationData*/ annotationData, Class<T> annotationClass, T annotation, int classRedefinedCount) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//        Map<Class<? extends Annotation>, Annotation> annotations = (Map<Class<? extends Annotation>, Annotation>) AnnotationData_annotations.get(annotationData);
//        Map<Class<? extends Annotation>, Annotation> declaredAnnotations= (Map<Class<? extends Annotation>, Annotation>) AnnotationData_declaredAnotations.get(annotationData);
//
//        Map<Class<? extends Annotation>, Annotation> newDeclaredAnnotations = new LinkedHashMap<>(annotations);
//        newDeclaredAnnotations.put(annotationClass, annotation);
//        Map<Class<? extends Annotation>, Annotation> newAnnotations ;
//        if (declaredAnnotations == annotations) {
//            newAnnotations = newDeclaredAnnotations;
//        } else{
//            newAnnotations = new LinkedHashMap<>(annotations);
//            newAnnotations.put(annotationClass, annotation);
//        }
//        return AnnotationData_constructor.newInstance(newAnnotations, newDeclaredAnnotations, classRedefinedCount);
//    }

//    @SuppressWarnings("unchecked")
//    public static <T extends Annotation> T annotationForMap(final Class<T> annotationClass, final Map<String, Object> valuesMap){
//        return (T) AccessController.doPrivileged(new PrivilegedAction<Annotation>(){
//            public Annotation run(){
//                InvocationHandler handler;
//                try {
//                    handler = (InvocationHandler) AnnotationInvocationHandler_constructor.newInstance(annotationClass,new HashMap<>(valuesMap));
//                } catch (InstantiationException | IllegalAccessException
//                         | IllegalArgumentException | InvocationTargetException e) {
//                    throw new IllegalStateException(e);
//                }
//                return (Annotation) Proxy.newProxyInstance(annotationClass.getClassLoader(), new Class[] { annotationClass }, handler);
//            }
//        });
//    }

    private void replaceAnnotation(Class<?> where, Class<? extends Annotation> annotationType, Annotation newAnnotation) {
        try {
            Method annotationMethod = where.getSuperclass().getClass().getDeclaredMethod(ANNOTATION_METHOD);
            if(annotationMethod.trySetAccessible()){
                annotationMethod.setAccessible(true);

                Object annotationData = annotationMethod.invoke(where);

                Field annotations = annotationData.getClass().getDeclaredField(ANNOTATIONS);
                annotations.setAccessible(true);

                Map<Class<? extends Annotation>, Annotation> annotationsMap =
                        (Map<Class<? extends Annotation>, Annotation>) annotations.get(annotationData);
                annotationsMap.put(annotationType, newAnnotation);
            }


        } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
