/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u10416008fxgame;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.TriangleMesh;

/**
 *
 * @author user
 */
public class Room3Ob extends TriangleMesh{
    
    public Room3Ob(){
        
        paint();
    }
    public void paint(){
        
        //height *= .5f;
        float x = 300 ,y =100 , z = 300; 
        float points[] = {
            0, 0, 0,
            -x/2, y , -z/2,
            -x/2, y , z/2,
            x/2, y , -z/2,
            x/2, y , z/2,
            -x/2, y+30 , -z/2,
            -x/2, y+30 , z/2,
            x/2, y+30 , -z/2,
            x/2, y+30 , z/2    
    
        };
        float texcoords[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

        int faces[] = {
            
            0,0, 1,0, 3,0,
            1,0, 5,0, 3,0,
            3,0, 5,0, 7,0,
            0,0, 3,0, 4,0,
            3,0, 7,0, 4,0,
            4,0, 7,0, 8,0,
            0,0, 4,0, 2,0,
            4,0, 8,0, 6,0,
            2,0, 4,0, 6,0,
            0,0, 2,0, 1,0,
            1,0, 2,0, 6,0, 
            1,0, 6,0, 5,0, 
            5,0, 6,0, 7,0,
            6,0, 8,0, 7,0
            
        };
       

        // Faces


        // build cap faces
      

        int smoothing[] = {};


        getPoints().addAll(points);
        getTexCoords().addAll(texcoords);
        getFaces().addAll(faces);
        getFaceSmoothingGroups().addAll( smoothing);
        
    }
}
