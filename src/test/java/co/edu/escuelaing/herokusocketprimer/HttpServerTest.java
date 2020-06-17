/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.herokusocketprimer;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Imac
 */
public class HttpServerTest {
    @Test
    public void Client(){
        ExecutorService pool = Executors.newFixedThreadPool(102);
        pool.submit(new Runnable(){
            public void run(){
                try {
                    HttpServer.main(null);
                } catch (IOException ex) {
                    Logger.getLogger(HttpServerTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        String[] args = {"GET /pagina/index.html"};
        for(int i=0;i<100;i++){
            pool.submit(new Runnable(){
                public void run(){
                    try {
                        HttpClient.main(args);
                    } catch (IOException ex) {
                        Logger.getLogger(HttpServerTest.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }
        args[0] = "bye";
        pool.submit(new Runnable(){
            public void run(){
                try {
                    HttpClient.main(args);
                } catch (IOException ex) {
                    Logger.getLogger(HttpServerTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        pool.shutdown();
        assertTrue(true);
    }
}
