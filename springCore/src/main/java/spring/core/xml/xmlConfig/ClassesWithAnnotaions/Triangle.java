/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.xml.xmlConfig.ClassesWithAnnotaions;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import spring.core.xml.xmlConfig.classes.*;

@Component                       //    // this annotation is avaliable for execute  annotations/A1pplicationContext.xml
@Scope(value = "singleton")

public class Triangle implements DisposableBean, InitializingBean {

    Logger logger = Logger.getLogger(this.getClass().toString());
    List<Point> list;
    @Autowired    //    // this annotation is avaliable for execute  annotations/A1pplicationContext.xml
    private Point pointA;
    @Autowired    //    // this annotation is avaliable for execute  annotations/A1pplicationContext.xml
    private Point pointB;
    @Autowired    //    // this annotation is avaliable for execute  annotations/A1pplicationContext.xml
    private Point pointC;

    public Triangle() {
        logger.info("\n\nExecuting Triangle Constructor");
    }

    public void init() {
        logger.info("\n\nMy init method is called for Triangle");

    }

    public void predestory() {
        logger.info("\n\nMy predestory method is called for Triangle");

    }

    @PostConstruct        // this annotation is avaliable for execute  annotations/A1pplicationContext.xml
    public void postConstruct() {
        logger.info("\n\nMy  @PostConstruct    method is called for Triangle");

    }

    @PreDestroy    // this annotation is avaliable for execute  annotations/A1pplicationContext.xml
    public void PreDestroy() {
        logger.info("\n\nMy @PreDestroy   method is called for Triangle");

    }

    @Override
    public void destroy() throws Exception {
        logger.info("\n\nMy destroy method is called for Triangle");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("\n\nMy afterPropertiesSet method is called for Triangle");
    }

    /**
     * @param pointA the pointA to set
     */
    public void setPointA(Point pointA) {
        logger.info("\n\nMy setPointA method is called for Triangle");

        this.pointA = pointA;
    }

    public List<Point> getList() {
        logger.info("\n\nMy getList method is called for Triangle");

        return list;
    }

    public void setList(List<Point> list) {
        logger.info("\n\nMy setList method is called for Triangle");

        this.list = list;
    }

    /**
     * @param pointB the pointB to set
     */
    public void setPointB(Point pointB) {
        logger.info("\n\nMy setPointB method is called for Triangle");

        this.pointB = pointB;
    }

    /**
     * @param pointC the pointC to set
     */
    public void setPointC(Point pointC) {
        logger.info("\n\nMy setPointC method is called for Triangle");

        this.pointC = pointC;
    }

    public void draw() {
        logger.info("\n\nMy draw method is called for Triangle");

        System.out.println("PointA is (" + pointA.getX() + ", " + pointA.getY() + ")");
        System.out.println("PointB is (" + pointB.getX() + ", " + pointB.getY() + ")");
        System.out.println("PointC is (" + pointC.getX() + ", " + pointC.getY() + ")");

        logger.info("\n\nMy draw method is executrd for Triangle");

    }

    public void drawList() {
        System.out.println("================  LIst POint ================");
        Iterator<Point> iterator = list.iterator();
        while (iterator.hasNext()) {
            Point next = iterator.next();
            System.out.println("PointA is (" + next.getX() + ", " + next.getY() + ")");
        }
    }

}
