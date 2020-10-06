import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author ale
 */
public class animacion {
    // COORDENADAS
    private int coordenadax,coordenaday;
    //tamaño
    private int radio;
    // color
    private Color color;
    //Sentido en que se mueve
    private int sentido;
    //sentidos posibles
    private final int arriba=1;
    private final int arribad=2;
    private final int derecha=3;
    private final int derechaa=4;
    private final int abajo=5;
    private final int abajoi=6;
    private final int izquierda=7;
    private final int izquierdaa=8;
    //velocidad
    private int velocidad;
    //margenes de la ventana
    private int minimox,minimoy,maxx,maxy;
    //objeto random
    private Random random;
    public animacion(int ancho,int alto,int radio,int velocidad){
        //definiendo objeto random
        random= new Random();
        color=new Color(
                random.nextInt(255),
                random.nextInt(255),
                random.nextInt(255)
        );
        //definir coordenadas iniciales
        this.coordenadax=this.random.nextInt(ancho-radio);
        this.coordenaday=this.random.nextInt(alto-radio);
        //definir radio
        this.radio=radio;
        //definir sentido
        this.sentido=1+random.nextInt(8);
        //definir velocidad
        this.velocidad=velocidad;
        //definir margenes
        this.minimox=0;
        this.minimoy=0;
        this.maxx=ancho-30;
        this.maxy=alto-50;
    }
    public void dibujar(Graphics graphics){
        graphics.setColor(this.color);
        graphics.fillOval(
                this.coordenadax,
                this.coordenaday,
                this.radio,
                this.radio
        );
    }
    public void animar(){
        // Siguientes coordenadas postivas
        int xpositiva=this.coordenadax+this.velocidad;
        int ypositiva=this.coordenaday+this.velocidad;
        // Siguientes coordenadas negativas
        int xnegativa=this.coordenadax-this.velocidad;
        int ynegativa=this.coordenaday-this.velocidad;
        //logica para derterminar colisiones y sentido
        switch(this.sentido){
            case arriba:
                if (ynegativa>this.minimoy) {
              this.coordenaday=ynegativa;
                }else{
                    int sentidotemp=1+random.nextInt(3);
                    switch(sentidotemp){
                case 1:
                this.sentido=izquierdaa;
                break;
                        case 2:
                this.sentido=abajo;
                break;
                        case 3:
                            this.sentido=derechaa;
                            break;
                    }
                }
                break;
            case arribad:
                if (ynegativa>this.minimoy && xpositiva<this.maxx) {
                    this.coordenaday=ynegativa;
                    this.coordenadax=xpositiva;
                }else{
                    int sentidotemp=1+random.nextInt(3);
                    switch(sentidotemp){
                        case 1:
                            this.sentido=izquierda;
                            break;
                        case 2:
                            this.sentido=izquierdaa;
                            break;
                        case 3:
                            this.sentido=abajo;
                            break;
                    }
                }
                break;
            case derecha:
                if (xpositiva<this.maxx) {
                    this.coordenadax=xpositiva;
                }else{
                    int sentidotemp=1+random.nextInt(3);
                    switch(sentidotemp){
                        case 1:
                            this.sentido=izquierda;
                            break;
                        case 2:
                            this.sentido=izquierdaa;
                            break;
                        case 3:
                            this.sentido=abajoi;
                            break;
                    }
                }
                break;
            case derechaa:
                if (ypositiva<this.maxy && xpositiva<this.maxx) {
                    this.coordenaday=ypositiva;
                    this.coordenadax=xpositiva;
                }else{
                    int sentidotemp=1+random.nextInt(3);
                    switch(sentidotemp){
                        case 1:
                            this.sentido=izquierda;
                            break;
                        case 2:
                            this.sentido=izquierdaa;
                            break;
                        case 3:
                            this.sentido=arriba;
                            break;
                    }
                }
                break;
            case abajo:
                if (ypositiva<this.maxy) {
                    this.coordenaday=ypositiva;
                }else{
                    int sentidotemp=1+random.nextInt(3);
                    switch(sentidotemp){
                        case 1:
                            this.sentido=arribad;
                            break;
                        case 2:
                            this.sentido=izquierdaa;
                            break;
                        case 3:
                            this.sentido=arriba;
                            break;
                    }
                }
                break;
            case abajoi:
                if (ypositiva<this.maxy&&xnegativa>this.minimox) {
                    this.coordenaday=ypositiva;
                    this.coordenadax=xnegativa;
                }else{
                    int sentidotemp=1+random.nextInt(3);
                    switch(sentidotemp){
                        case 1:
                            this.sentido=arribad;
                            break;
                        case 2:
                            this.sentido=derecha;
                            break;
                        case 3:
                            this.sentido=arriba;
                            break;
                    }
                }
                break;
            case izquierda:
                if(xnegativa>this.minimox){
                    this.coordenadax=xnegativa;
                }else{
                  int sentidotemp=1+random.nextInt(3);
                    switch(sentidotemp){
                        case 1:
                            this.sentido=arribad;
                            break;
                        case 2:
                            this.sentido=derecha;
                            break;
                        case 3:
                            this.sentido=derechaa;
                            break;
                    }  
                }
                break;
            case izquierdaa:
                if(xnegativa>this.minimox && ynegativa>this.minimoy){
                    this.coordenadax=xnegativa;
                    this.coordenaday=ynegativa;
                }else{
                  int sentidotemp=1+random.nextInt(3);
                    switch(sentidotemp){
                        case 1:
                            this.sentido=derecha;
                            break;
                        case 2:
                            this.sentido=derechaa;
                            break;
                        case 3:
                            this.sentido=abajo;
                            break;
                    } 
                }
                break;
                
        }
    }
}