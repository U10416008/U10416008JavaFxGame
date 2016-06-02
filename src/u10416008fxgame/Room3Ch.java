package u10416008fxgame;


import javafx.scene.shape.TriangleMesh;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Room3Ch extends TriangleMesh{
    public Room3Ch(){
        paint();
    }
    public void paint(){
        
        
        int divisions = 120;
        final int nPoints = divisions*(divisions) + 1;

        float points[] = new float[(nPoints+ divisions) * 3];
        float x = 300 ,y =150;
        float dx, dy;
        int po = 0;
        for(int i = 0 ; i< divisions ;i++){
            dx = (x/2/divisions) * (i+1);
            dy =(float)(-y*Math.cos(Math.PI/2/divisions * (i+1)));
            
            for(int j = 0 ;j < divisions ; j++){
                
                points[po] = (float)(dx*Math.cos(2*Math.PI/divisions * j));
                points[po+1]= dy;
                points[po+2] = (float)(dx*Math.sin(2*Math.PI/divisions * j));
                po = po + 3;
            }
            
        }
        for(int i = 0 ; i <= divisions/6 ; i++){
            
            dy = (float)(250-75*Math.sin((Math.PI)/(divisions/6)*i));
            points[po] = (float)(x/2*Math.cos((Math.PI*0)+ (Math.PI/3)/(divisions/6) * i));
            points[po+1]= dy; 
            points[po+2] = (float)(x/2*Math.sin((Math.PI*0)+ (Math.PI/3)/(divisions/6) * i));
            po = po + 3;
        }
        for(int i = 1 ; i < divisions/3; i++){
            
            dy = 250;
            points[po] = (float)(x/2*Math.cos((Math.PI/3)+(2*Math.PI/3)/(divisions/3) * i));
            points[po+1]= dy; 
            points[po+2] = (float)(x/2*Math.sin((Math.PI/3)+(2*Math.PI/3)/(divisions/3) * i));
            po = po + 3;
        }
        for(int i = 0 ; i <= divisions/6 ; i++){
            
            dy = (float)(250-75*Math.sin((Math.PI)/(divisions/6)*i));
            points[po] = (float)(x/2*Math.cos((Math.PI*1)+ (Math.PI/3)/(divisions/6) * i));
            points[po+1]= dy; 
            points[po+2] = (float)(x/2*Math.sin((Math.PI*1)+ (Math.PI/3)/(divisions/6) * i));
            po = po + 3;
        }
        
        for(int i = 1 ; i < divisions/3 ; i++){
            
            dy = 250;
            points[po] = (float)(x/2*Math.cos((4*Math.PI/3)+(2*Math.PI/3)/(divisions/3) * i));
            points[po+1]= dy; 
            points[po+2] = (float)(x/2*Math.sin((4*Math.PI/3)+(2*Math.PI/3)/(divisions/3) * i));
            po = po + 3;
        }
        
        points[po ] = 0;
        points[po +1] = -y;
        points[po +2] = 0;
        
        
        float texcoords[] = {0,0};
        
        int k = 0;
        int faces[] = new int[6*(2*divisions*(divisions) + divisions +divisions)];
        for(int i = 0 ; i< divisions-1 ;i++){
            for(int j =0 ; j<divisions; j++){
                
                faces[k]= j+i*divisions;
                faces[k+1]= 0;
                faces[k+2]= j+(i+1)*divisions;
                faces[k+3]= 0;
                faces[k+4]= ((j+(i+1)*divisions+1) == (i+2)*divisions)? ((i+1)*divisions) : (j+(i+1)*divisions+1);
                faces[k+5]= 0;
                
                k = k+6;
                faces[k]= j+i*divisions;
                faces[k+1]= 0;
                faces[k+2]= ((j+(i+1)*divisions+1) == (i+2)*divisions)? ((i+1)*divisions) : (j+(i+1)*divisions+1);
                faces[k+3]= 0;
                faces[k+4]= ((j+i*divisions+1 )== (i+1)*divisions)? (i*divisions ):( j+i*divisions+1);
                faces[k+5]= 0;
                k = k+6;
            }
        }
        for(int i = 0 ; i < divisions ; i++){
            faces[k] = i + divisions*(divisions-1);
            faces[k+1] = 0;
            faces[k+2] = i + divisions*(divisions);
            faces[k+3] = 0;
            faces[k+4] = i + divisions*(divisions)+1 == divisions*(divisions+1)? divisions*(divisions) : i + divisions*(divisions)+1  ;
            faces[k+5] = 0;
            k = k+6;
            faces[k] = i + divisions*(divisions-1);
            faces[k+1] = 0;
            faces[k+2] = i + divisions*(divisions)+1 == divisions*(divisions+1)? divisions*(divisions) : i + divisions*(divisions)+1  ;
            faces[k+3] = 0;
            faces[k+4] = i + divisions*(divisions-1)+1 == divisions*(divisions)? divisions*(divisions-1) : i + divisions*(divisions-1)+1  ;
            faces[k+5] = 0;
            k = k+6;
        }
        
        faces[k] = divisions*(divisions+1)-divisions/6 ;
        faces[k+1] = 0;
        faces[k+2] = divisions*(divisions+1)-divisions/6 -1;
        faces[k+3] = 0;
        faces[k+4] =  divisions*(divisions+1)-divisions/6 +1;
        faces[k+5] = 0;
        k = k+6;
        for(int i = 1 ; i<=(divisions-2)/2 ; i++ ){
            faces[k] = divisions*(divisions+1)-divisions/6 -i;
            faces[k+1] = 0;
            faces[k+2] = divisions*(divisions+1)-divisions/6 +i+1 >= divisions*(divisions+1)? divisions*(divisions)-divisions/6 +i+1:divisions*(divisions+1)-divisions/6 +i+1;
            faces[k+3] = 0;
            faces[k+4] = divisions*(divisions+1)-divisions/6 +i >= divisions*(divisions+1)? divisions*(divisions)-divisions/6 +i :divisions*(divisions+1)-divisions/6 +i;
            faces[k+5] = 0;
            k = k+6;
            faces[k] = divisions*(divisions+1)-divisions/6-i;
            faces[k+1] = 0;
            faces[k+2] = divisions*(divisions+1)-divisions/6-i-1;
            faces[k+3] = 0;
            faces[k+4] =  divisions*(divisions+1)-divisions/6 +i+1 >= divisions*(divisions+1)? divisions*(divisions)-divisions/6 +i+1 :divisions*(divisions+1)-divisions/6 +i+1;
            faces[k+5] = 0;
            k = k+6;
        }
        faces[k] = divisions*(divisions)+2*divisions/6 ;
        faces[k+1] = 0;
        faces[k+2] = divisions*(divisions)+2*divisions/6 -1;
        faces[k+3] = 0;
        faces[k+4] =  divisions*(divisions)+2*divisions/6 +1;
        faces[k+5] = 0;
        k = k+6;
        for(int i = 0 ; i < divisions; i++){
            
            faces[k] = (divisions+1)*divisions;
            faces[k+1] = 0;
            faces[k+2] = i;
            faces[k+3] = 0;
            faces[k+4] = (i+1) == divisions? 0 :i+1;
            faces[k+5] = 0;
            k = k+6;
            
        
        }
        int smoothing[] = {};
        getPoints().addAll(points);
        getTexCoords().addAll(texcoords);
        getFaces().addAll(faces);
        getFaceSmoothingGroups().addAll( smoothing);
    }
}
