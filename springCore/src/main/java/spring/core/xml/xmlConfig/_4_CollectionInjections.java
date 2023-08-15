/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.xml.xmlConfig;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.xml.xmlConfig.classes.Point;

/**
 *
 * @author mohamed.aljazwiee
 */
public class _4_CollectionInjections {

    private List<String> stringList;
    private Set<String> stringSet;
    private Map<Integer, String> stringMap;
    private Properties properties;

    private List<Point> pointList;
    private Set<Point> pointSet;
    private Map<Integer, Point> pointMap;

    public _4_CollectionInjections() {
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public Set<String> getStringSet() {
        return stringSet;
    }

    public void setStringSet(Set<String> stringSet) {
        this.stringSet = stringSet;
    }

    public Map<Integer, String> getStringMap() {
        return stringMap;
    }

    public void setStringMap(Map<Integer, String> stringMap) {
        this.stringMap = stringMap;
    }

    public List<Point> getPointList() {
        return pointList;
    }

    public void setPointList(List<Point> pointList) {
        this.pointList = pointList;
    }

    public Set<Point> getPointSet() {
        return pointSet;
    }

    public void setPointSet(Set<Point> pointSet) {
        this.pointSet = pointSet;
    }

    public Map<Integer, Point> getPointMap() {
        return pointMap;
    }

    public void setPointMap(Map<Integer, Point> pointMap) {
        this.pointMap = pointMap;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "_4_CollectionInjections{"
                + "stringList=" + stringList
                + "\n , stringSet=" + stringSet
                + "\n, stringMap=" + stringMap
                + "\n\n\n, pointList=" + pointList
                + "\n, pointSet=" + pointSet
                + "\n, pointMap=" + pointMap
                + "\n ,properties  " + properties + '}';
    }

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:resources/XML/collections.xml");
        _4_CollectionInjections collectionInjections = ac.getBean(_4_CollectionInjections.class);
        System.out.println(collectionInjections);
    }

}
