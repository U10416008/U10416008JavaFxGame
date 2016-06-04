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
public class Room3S extends TriangleMesh{
    public Room3S(){
        
    }
    public void paintS(){
        int divisions = 75;
        float r = 50;
        float R = 100;
        float point[] = new float[3*divisions*8];
        int k = 0;
        for(int i = 0; i < divisions; i++){
            point[k] = (float)(R*Math.cos(3f/4f/(divisions-1) * i  * 2*Math.PI));
            point[k+1] = -R - (float)(R*Math.sin((3f/4f/(divisions-1)) * 2 * Math.PI * i));
            point[k+2] = 0;
            k = k+3;
            point[k] = (float)(r*Math.cos((3f/4f/(divisions-1)) * 2 * Math.PI * i));
            point[k+1] = -R - (float)(r*Math.sin((3f/4f/(divisions-1)) * 2 * Math.PI * i));
            point[k+2] = 0;
            k = k+3;
            
        }
        for(int i = 1; i < divisions; i++){
            point[k] = (float)(r*Math.cos((1f/4f - (3f/4f/(divisions-1))* i) * 2 * Math.PI ));
            point[k+1] = -(float)(r*Math.sin((1f/4f - (3f/4f/(divisions-1))* i) * 2 * Math.PI ))+r;
            point[k+2] = 0;
            k = k+3;
            point[k] = (float)(R*Math.cos((1f/4f - (3f/4f/(divisions-1))* i) * 2 * Math.PI ));
            point[k+1] = -(float)(R*Math.sin((1f/4f - (3f/4f/(divisions-1))* i) * 2 * Math.PI ))+r;
            point[k+2] = 0;
            k = k+3;
            
        }
        for(int i = 0; i < divisions; i++){
            point[k] = (float)(R*Math.cos((3f/4f/(divisions-1)) * 2 * Math.PI * i));
            point[k+1] = -R - (float)(R*Math.sin((3f/4f/(divisions-1)) * 2 * Math.PI * i));
            point[k+2] = 30;
            k = k+3;
            point[k] = (float)(r*Math.cos((3f/4f/(divisions-1)) * 2 * Math.PI * i));
            point[k+1] = -R - (float)(r*Math.sin((3f/4f/(divisions-1)) * 2 * Math.PI * i));
            point[k+2] = 30;
            k = k+3;
            
        }
        for(int i = 1; i < divisions; i++){
            point[k] = (float)(r*Math.cos((1f/4f - (3f/4f/(divisions-1))* i) * 2 * Math.PI ));
            point[k+1] = -(float)(r*Math.sin((1f/4f - (3f/4f/(divisions-1))* i) * 2 * Math.PI ))+r;
            point[k+2] = 30;
            k = k+3;
            point[k] = (float)(R*Math.cos((1f/4f - (3f/4f/(divisions-1))* i) * 2 * Math.PI ));
            point[k+1] = -(float)(R*Math.sin((1f/4f - (3f/4f/(divisions-1))* i) * 2 * Math.PI ))+r;
            point[k+2] = 30;
            k = k+3;
            
        }
        float tex[] = {0,0};
        int faces[] = new int[6*2*4*(2*(divisions-1))+24];
        int f = 0;
        for(int i = 0 ; i < 4*(divisions-1) ; i = i+2){
            faces[f] = i;
            faces[f+1] = 0;
            faces[f+2] = i+2;
            faces[f+3] = 0;
            faces[f+4] = i+1;
            faces[f+5] = 0;
            f = f+6;
            faces[f] = i+1;
            faces[f+1] = 0;
            faces[f+2] = i+2;
            faces[f+3] = 0;
            faces[f+4] = i+3;
            faces[f+5] = 0;
            f = f+6;
            
        }
        for(int i = 0 ; i < 4*(divisions-1) ; i = i+2){
            faces[f] = i+298;
            faces[f+1] = 0;
            faces[f+2] = i+299;
            faces[f+3] = 0;
            faces[f+4] = i+300;
            faces[f+5] = 0;
            f = f+6;
            faces[f] = i+299;
            faces[f+1] = 0;
            faces[f+2] = i+301;
            faces[f+3] = 0;
            faces[f+4] = i+300;
            faces[f+5] = 0;
            f = f+6;
            
        }
        for(int i = 0 ; i < 4*(divisions-1) ; i = i+2){
            faces[f] = i;
            faces[f+1] = 0;
            faces[f+2] = i+298;
            faces[f+3] = 0;
            faces[f+4] = i+300;
            faces[f+5] = 0;
            f = f+6;
            faces[f] = i;
            faces[f+1] = 0;
            faces[f+2] = i+300;
            faces[f+3] = 0;
            faces[f+4] = i+2;
            faces[f+5] = 0;
            f = f+6;
            
        }
        for(int i = 0 ; i < 4*(divisions-1) ; i = i+2){
            faces[f] = i+1;
            faces[f+1] = 0;
            faces[f+2] = i+3;
            faces[f+3] = 0;
            faces[f+4] = i+299;
            faces[f+5] = 0;
            f = f+6;
            faces[f] = i+3;
            faces[f+1] = 0;
            faces[f+2] = i+301;
            faces[f+3] = 0;
            faces[f+4] = i+299;
            faces[f+5] = 0;
            f = f+6;
            
        }
        faces[f] = 0;
        faces[f+1] = 0;
        faces[f+2] = 299;
        faces[f+3] = 0;
        faces[f+4] = 298;
        faces[f+5] = 0;
        f = f+6;
        faces[f] = 0;
        faces[f+1] = 0;
        faces[f+2] = 1;
        faces[f+3] = 0;
        faces[f+4] = 299;
        faces[f+5] = 0;
        f = f+6;
        faces[f] = 296;
        faces[f+1] = 0;
        faces[f+2] = 594;
        faces[f+3] = 0;
        faces[f+4] = 595;
        faces[f+5] = 0;
        f = f+6;
        faces[f] = 296;
        faces[f+1] = 0;
        faces[f+2] = 595;
        faces[f+3] = 0;
        faces[f+4] = 297;
        faces[f+5] = 0;
        f = f+6;
        
        getPoints().clear();
        getTexCoords().clear();
        getFaces().clear();
        getPoints().addAll(point);
        getTexCoords().addAll(tex);
        getFaces().addAll(faces);
        
        
    }
    
}
