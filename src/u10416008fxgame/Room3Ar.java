/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u10416008fxgame;

import javafx.scene.shape.TriangleMesh;
/**
 *
 * @author user
 */
public class Room3Ar extends TriangleMesh{
    
    public Room3Ar(){
        paint();
    }
    public void paint(){
        float points[] = {
            -20, 0, 0,
             0, 20, 0,
             0, 10, 0,
             40,10, 0,
             40,-10,0,
             0,-10, 0,
             0,-20, 0,
            -20, 0, 20,
             0, 20, 20,
             0, 10, 20,
             40,10, 20,
             40,-10,20,
             0,-10, 20,
             0,-20, 20
             
        };
        float texcoords[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int faces[] = {
            0,0, 1,0, 2,0,
            0,0, 2,0, 3,0,
            0,0, 3,0, 4,0,
            0,0, 4,0, 5,0,
            0,0, 5,0, 6,0,
            0,0, 8,0, 1,0,
            0,0, 7,0, 8,0,
            1,0, 8,0, 2,0,
            8,0, 9,0, 2,0,
            2,0, 9,0, 10,0,
            2,0, 10,0, 3,0,
            3,0, 10,0, 4,0,
            10,0, 11,0, 4,0,
            5,0, 4,0, 11,0,
            12,0, 5,0, 11,0,
            5,0, 12,0, 6,0,
            12,0, 13,0, 6,0,
            7,0, 0,0, 6,0,
            7,0, 6,0, 13,0,
            7,0 ,9,0, 8,0,
            7,0 ,10,0, 9,0,
            7,0 ,11,0, 10,0,
            7,0 ,12,0, 11,0,
            7,0 ,13,0, 12,0,
        };
        int smoothing[] = {};


        getPoints().addAll(points);
        getTexCoords().addAll(texcoords);
        getFaces().addAll(faces);
        getFaceSmoothingGroups().addAll( smoothing);
    }
}
