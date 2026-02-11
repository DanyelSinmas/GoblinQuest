package Mapa;

import Personajes.Protagonista;
import java.io.Serializable;

/**
 * Clase que sirve para construir una matriz de casillas que representan el
 * tablero de juego
 *
 * @author Daniel MP
 */
public class Mapa implements Serializable {

    Casilla[][][] mapa;

    private Protagonista protagonista;

    public Mapa() {

        mapa = new Casilla[3][10][10];

        // Piso 0 (planta baja)
        //fila 1
        mapa[0][0][1] = new CasillaMuro(1);
        mapa[0][0][2] = new CasillaMuro(2);

        //fila 2
        mapa[0][1][0] = new CasillaMuro(3);
        mapa[0][1][1] = new CasillaEscalera(4, 0);
        mapa[0][1][2] = new CasillaMuro(5);
        mapa[0][1][3] = new CasillaMuro(6);
        mapa[0][1][7] = new CasillaMuro(7);
        mapa[0][1][8] = new CasillaMuro(8);

        //fila 3
        mapa[0][2][0] = new CasillaMuro(9);
        mapa[0][2][1] = new CasillaCombate(10, 4);
        mapa[0][2][2] = new CasillaMuro(11);
        mapa[0][2][3] = new CasillaCombate(12, 2);
        mapa[0][2][4] = new CasillaMuro(13);
        mapa[0][2][5] = new CasillaMuro(14);
        mapa[0][2][6] = new CasillaMuro(15);
        mapa[0][2][7] = new CasillaSuelo(16);
        mapa[0][2][8] = new CasillaObjeto(17, 0);
        mapa[0][2][9] = new CasillaMuro(18);

        //fila 4
        mapa[0][3][0] = new CasillaMuro(19);
        mapa[0][3][1] = new CasillaSuelo(20);
        mapa[0][3][2] = new CasillaMuro(21);
        mapa[0][3][3] = new CasillaDialogo(22, 3);
        mapa[0][3][4] = new CasillaSuelo(23);
        mapa[0][3][5] = new CasillaDialogo(24, 2);
        mapa[0][3][6] = new CasillaCombate(25, 1);
        mapa[0][3][7] = new CasillaDialogo(26, 1);
        mapa[0][3][8] = new CasillaSuelo(27);
        mapa[0][3][9] = new CasillaMuro(28);

        //fila 5
        mapa[0][4][0] = new CasillaMuro(29);
        mapa[0][4][1] = new CasillaDialogo(30, 5);
        mapa[0][4][2] = new CasillaMuro(31);
        mapa[0][4][3] = new CasillaSuelo(32);
        mapa[0][4][4] = new CasillaSuelo(33);
        mapa[0][4][5] = new CasillaMuro(34);
        mapa[0][4][6] = new CasillaMuro(35);
        mapa[0][4][7] = new CasillaSuelo(36);
        mapa[0][4][8] = new CasillaSuelo(37);
        mapa[0][4][9] = new CasillaMuro(38);

        //fila 6
        mapa[0][5][0] = new CasillaMuro(39);
        mapa[0][5][1] = new CasillaObjeto(40, 0);
        mapa[0][5][2] = new CasillaMuro(41);
        mapa[0][5][3] = new CasillaMuro(42);
        mapa[0][5][4] = new CasillaSuelo(43);
        mapa[0][5][5] = new CasillaSuelo(44);
        mapa[0][5][6] = new CasillaObjeto(45, 1);
        mapa[0][5][7] = new CasillaMuro(46);
        mapa[0][5][8] = new CasillaCombate(47, 0);
        mapa[0][5][9] = new CasillaMuro(48);

        //fila 7
        mapa[0][6][0] = new CasillaMuro(49);
        mapa[0][6][1] = new CasillaObjeto(50, 1);
        mapa[0][6][2] = new CasillaCombate(51, 3);
        mapa[0][6][3] = new CasillaDialogo(52, 4);
        mapa[0][6][4] = new CasillaSuelo(53);
        mapa[0][6][5] = new CasillaMuro(55);
        mapa[0][6][6] = new CasillaMuro(56);
        mapa[0][6][7] = new CasillaMuro(57);
        mapa[0][6][8] = new CasillaSuelo(58);
        mapa[0][6][9] = new CasillaMuro(59);

        //fila 8
        mapa[0][7][1] = new CasillaMuro(60);
        mapa[0][7][2] = new CasillaSuelo(61);
        mapa[0][7][3] = new CasillaObjeto(62, 0);
        mapa[0][7][4] = new CasillaMuro(63);
        mapa[0][7][5] = new CasillaMuro(64);
        mapa[0][7][6] = new CasillaObjeto(65, 0);
        mapa[0][7][7] = new CasillaDialogo(66, 0);
        mapa[0][7][8] = new CasillaHistoria(69,0);
        mapa[0][7][9] = new CasillaMuro(70);

        //fila 9
        mapa[0][8][2] = new CasillaMuro(71);
        mapa[0][8][3] = new CasillaMuro(72);
        mapa[0][8][4] = new CasillaMuro(73);
        mapa[0][8][6] = new CasillaMuro(74);
        mapa[0][8][7] = new CasillaMuro(75);
        //mapa[0][8][8] = new CasillaHistoria(76, 0);
        mapa[0][8][8] = new CasillaSuelo(76);
        mapa[0][8][9] = new CasillaMuro(77);

        //fila 10
        mapa[0][9][8] = new CasillaMuro(78);
        // Piso 1
// Fila 0
// Piso 1
// Fila 0
        mapa[1][0][0] = new CasillaMuro(100);
        mapa[1][0][1] = new CasillaMuro(101);
        mapa[1][0][2] = new CasillaMuro(102);
        mapa[1][0][3] = new CasillaMuro(103);
        mapa[1][0][4] = new CasillaMuro(104);
        mapa[1][0][5] = new CasillaMuro(105);
        mapa[1][0][6] = new CasillaMuro(106);
        mapa[1][0][7] = new CasillaMuro(107);
        mapa[1][0][8] = new CasillaMuro(108);
        mapa[1][0][9] = new CasillaMuro(109);

// Fila 1
        mapa[1][1][0] = new CasillaMuro(110);
        mapa[1][1][1] = new CasillaEscalera(111, 0); // escalera 0-1 (piso 0 -> 1)
        mapa[1][1][2] = new CasillaMuro(112);
        mapa[1][1][3] = new CasillaMuro(113);
        mapa[1][1][4] = new CasillaMuro(114);
        mapa[1][1][5] = new CasillaMuro(115);
        mapa[1][1][6] = new CasillaMuro(116);
        mapa[1][1][7] = new CasillaMuro(117);
        mapa[1][1][8] = new CasillaEscalera(118, 1); // escalera 1-2 (piso 1 -> 2)
        mapa[1][1][9] = new CasillaMuro(119);

// Fila 2
        mapa[1][2][0] = new CasillaMuro(120);
        mapa[1][2][1] = new CasillaSuelo(121); // suelo
        mapa[1][2][2] = new CasillaMuro(122);
        mapa[1][2][3] = new CasillaObjeto(123, 0); // cura
        mapa[1][2][4] = new CasillaMuro(124);
        mapa[1][2][5] = new CasillaMuro(125);
        mapa[1][2][6] = new CasillaSuelo(126); // suelo
        mapa[1][2][7] = new CasillaMuro(127);
        mapa[1][2][8] = new CasillaSuelo(128); // suelo
        mapa[1][2][9] = new CasillaMuro(129);

// Fila 3
        mapa[1][3][0] = new CasillaMuro(130);
        mapa[1][3][1] = new CasillaSuelo(131); // suelo
        mapa[1][3][2] = new CasillaMuro(132);
        mapa[1][3][3] = new CasillaSuelo(133); // suelo
        mapa[1][3][4] = new CasillaMuro(134);
        mapa[1][3][5] = new CasillaSuelo(135); // suelo
        mapa[1][3][6] = new CasillaSuelo(136); // suelo
        mapa[1][3][7] = new CasillaMuro(137);
        mapa[1][3][8] = new CasillaCombate(138, 8); // combate 8
        mapa[1][3][9] = new CasillaMuro(139);

// Fila 4
        mapa[1][4][0] = new CasillaMuro(140);
        mapa[1][4][1] = new CasillaDialogo(141, 6); // dialogo 6
        mapa[1][4][2] = new CasillaSuelo(142); // suelo
        mapa[1][4][3] = new CasillaCombate(143, 7); // combate 7
        mapa[1][4][4] = new CasillaSuelo(144); // suelo
        mapa[1][4][5] = new CasillaSuelo(145); // suelo
        mapa[1][4][6] = new CasillaSuelo(146); // suelo
        mapa[1][4][7] = new CasillaSuelo(147); // suelo
        mapa[1][4][8] = new CasillaSuelo(148); // suelo
        mapa[1][4][9] = new CasillaMuro(149);

// Fila 5
        mapa[1][5][0] = new CasillaMuro(150);
        mapa[1][5][1] = new CasillaSuelo(151); // suelo
        mapa[1][5][2] = new CasillaSuelo(152); // suelo
        mapa[1][5][3] = new CasillaMuro(153);
        mapa[1][5][4] = new CasillaMuro(154);
        mapa[1][5][5] = new CasillaSuelo(155); // suelo
        mapa[1][5][6] = new CasillaSuelo(156); // suelo
        mapa[1][5][7] = new CasillaSuelo(157); // suelo
        mapa[1][5][8] = new CasillaMuro(158);
        mapa[1][5][9] = new CasillaMuro(159);

// Fila 6
        mapa[1][6][0] = new CasillaMuro(160);
        mapa[1][6][1] = new CasillaSuelo(161); // suelo
        mapa[1][6][2] = new CasillaMuro(162);
        mapa[1][6][3] = new CasillaMuro(163);
        mapa[1][6][4] = new CasillaObjeto(164, 0); 
        mapa[1][6][5] = new CasillaSuelo(165); // suelo
        mapa[1][6][6] = new CasillaMuro(166);
        mapa[1][6][7] = new CasillaSuelo(167); // suelo
        mapa[1][6][8] = new CasillaMuro(168);
        mapa[1][6][9] = new CasillaMuro(169);

// Fila 7
        mapa[1][7][0] = new CasillaMuro(170);
        mapa[1][7][1] = new CasillaSuelo(171); // suelo
        mapa[1][7][2] = new CasillaMuro(172);
        mapa[1][7][3] = new CasillaMuro(173);
        mapa[1][7][4] = new CasillaMuro(174);
        mapa[1][7][5] = new CasillaMuro(175);
        mapa[1][7][6] = new CasillaMuro(176);
        mapa[1][7][7] = new CasillaDialogo(177, 7); // dialogo 7
        mapa[1][7][8] = new CasillaCombate(178, 5); // combate 9
        mapa[1][7][9] = new CasillaMuro(179);

// Fila 8
        mapa[1][8][0] = new CasillaMuro(180);
        mapa[1][8][1] = new CasillaCombate(181, 6);
        mapa[1][8][2] = new CasillaObjeto(182, 1); // obj ataque
        mapa[1][8][3] = new CasillaMuro(183);
        mapa[1][8][4] = new CasillaMuro(184);
        mapa[1][8][5] = new CasillaMuro(185);
        mapa[1][8][6] = new CasillaMuro(186);
        mapa[1][8][7] = new CasillaMuro(187);
        mapa[1][8][8] = new CasillaObjeto(188, 0); // obj cura 0
        mapa[1][8][9] = new CasillaMuro(189);

// Fila 9
        mapa[1][9][0] = new CasillaMuro(190);
        mapa[1][9][1] = new CasillaMuro(191);
        mapa[1][9][2] = new CasillaMuro(192);
        mapa[1][9][3] = new CasillaMuro(193);
        mapa[1][9][4] = new CasillaMuro(194);
        mapa[1][9][5] = new CasillaMuro(195);
        mapa[1][9][6] = new CasillaMuro(196);
        mapa[1][9][7] = new CasillaMuro(197);
        mapa[1][9][8] = new CasillaMuro(198);
        mapa[1][9][9] = new CasillaMuro(199);

        // Piso 2
// Fila 0
        mapa[2][0][0] = new CasillaMuro(200);
        mapa[2][0][1] = new CasillaMuro(201);
        mapa[2][0][2] = new CasillaMuro(202);
        mapa[2][0][3] = new CasillaMuro(203);
        mapa[2][0][4] = new CasillaMuro(204);
        mapa[2][0][5] = new CasillaMuro(205);
        mapa[2][0][6] = new CasillaMuro(206);
        mapa[2][0][7] = new CasillaMuro(207);
        mapa[2][0][8] = new CasillaMuro(208);
        mapa[2][0][9] = new CasillaMuro(209);

// Fila 1
        mapa[2][1][0] = new CasillaMuro(210);
        mapa[2][1][1] = new CasillaObjeto(211, 1); // objeto ataque (tipo 1)
        mapa[2][1][2] = new CasillaMuro(212);
        mapa[2][1][3] = new CasillaObjeto(213, 0); 
        mapa[2][1][4] = new CasillaMuro(214);
        mapa[2][1][5] = new CasillaSuelo(215); // suelo
        mapa[2][1][6] = new CasillaCombate(216, 11); // combate 11
        mapa[2][1][7] = new CasillaMuro(217);
        mapa[2][1][8] = new CasillaEscalera(218, 1); // escalera 2-1 (piso 2 -> 1)
        mapa[2][1][9] = new CasillaMuro(219);

// Fila 2
        mapa[2][2][0] = new CasillaMuro(220);
        mapa[2][2][1] = new CasillaObjeto(221, 1); // objeto ataque (tipo 1)
        mapa[2][2][2] = new CasillaMuro(222);
        mapa[2][2][3] = new CasillaSuelo(223); // suelo
        mapa[2][2][4] = new CasillaMuro(224);
        mapa[2][2][5] = new CasillaSuelo(225); // suelo
        mapa[2][2][6] = new CasillaMuro(226);
        mapa[2][2][7] = new CasillaMuro(227);
        mapa[2][2][8] = new CasillaSuelo(228); // suelo
        mapa[2][2][9] = new CasillaMuro(229);

// Fila 3
        mapa[2][3][0] = new CasillaMuro(230);
        mapa[2][3][1] = new CasillaSuelo(231); // suelo
        mapa[2][3][2] = new CasillaMuro(232);
        mapa[2][3][3] = new CasillaSuelo(233); // suelo
        mapa[2][3][4] = new CasillaSuelo(234); // suelo
        mapa[2][3][5] = new CasillaSuelo(235); // suelo
        mapa[2][3][6] = new CasillaObjeto(236, 0); // objeto cura (tipo 0)
        mapa[2][3][7] = new CasillaMuro(237);
        mapa[2][3][8] = new CasillaSuelo(238); // suelo
        mapa[2][3][9] = new CasillaMuro(239);

// Fila 4
        mapa[2][4][0] = new CasillaMuro(240);
        mapa[2][4][1] = new CasillaCombate(241, 10); // combate 10
        mapa[2][4][2] = new CasillaMuro(242);
        mapa[2][4][3] = new CasillaSuelo(243); // suelo
        mapa[2][4][4] = new CasillaSuelo(244); // suelo
        mapa[2][4][5] = new CasillaSuelo(245); // suelo
        mapa[2][4][6] = new CasillaMuro(246);
        mapa[2][4][7] = new CasillaMuro(247);
        mapa[2][4][8] = new CasillaDialogo(248, 8); // dialogo 8
        mapa[2][4][9] = new CasillaMuro(249);

// Fila 5
        mapa[2][5][0] = new CasillaMuro(250);
        mapa[2][5][1] = new CasillaSuelo(251); // suelo
        mapa[2][5][2] = new CasillaSuelo(252); // suelo
        mapa[2][5][3] = new CasillaSuelo(253); // suelo
        mapa[2][5][4] = new CasillaSuelo(254); // suelo
        mapa[2][5][5] = new CasillaSuelo(255); // suelo
        mapa[2][5][6] = new CasillaSuelo(256); // suelo
        mapa[2][5][7] = new CasillaSuelo(257); // suelo
        mapa[2][5][8] = new CasillaSuelo(258); // suelo
        mapa[2][5][9] = new CasillaMuro(259);

// Fila 6
        mapa[2][6][0] = new CasillaMuro(260);
        mapa[2][6][1] = new CasillaMuro(261);
        mapa[2][6][2] = new CasillaMuro(262);
        mapa[2][6][3] = new CasillaMuro(263);
        mapa[2][6][4] = new CasillaDialogo(264, 9); // dialogo 9
        mapa[2][6][5] = new CasillaMuro(265);
        mapa[2][6][6] = new CasillaSuelo(266); // suelo
        mapa[2][6][7] = new CasillaSuelo(267); // suelo
        mapa[2][6][8] = new CasillaSuelo(268); // suelo
        mapa[2][6][9] = new CasillaMuro(269);

// Fila 7
        mapa[2][7][0] = new CasillaMuro(270);
        mapa[2][7][1] = new CasillaMuro(271);
        mapa[2][7][2] = new CasillaMuro(272);
        mapa[2][7][3] = new CasillaMuro(273);
        mapa[2][7][4] = new CasillaSuelo(274); // suelo
        mapa[2][7][5] = new CasillaMuro(275);
        mapa[2][7][6] = new CasillaSuelo(276); // suelo
        mapa[2][7][7] = new CasillaMuro(277);
        mapa[2][7][8] = new CasillaMuro(278);
        mapa[2][7][9] = new CasillaMuro(279);

// Fila 8
        mapa[2][8][0] = new CasillaMuro(280);
        mapa[2][8][1] = new CasillaMuro(281);
        mapa[2][8][2] = new CasillaMuro(282);
        mapa[2][8][3] = new CasillaMuro(283);
        mapa[2][8][4] = new CasillaCombate(284, 12); // combate 12
        mapa[2][8][5] = new CasillaMuro(285);
        mapa[2][8][6] = new CasillaSuelo(286); // suelo
        mapa[2][8][7] = new CasillaCombate(287,9 ); // combate 9
        mapa[2][8][8] = new CasillaObjeto(288, 1); // obj ataque (tipo 1)
        mapa[2][8][9] = new CasillaMuro(289);

// Fila 9
        mapa[2][9][0] = new CasillaMuro(290);
        mapa[2][9][1] = new CasillaMuro(291);
        mapa[2][9][2] = new CasillaMuro(292);
        mapa[2][9][3] = new CasillaMuro(293);
        mapa[2][9][4] = new CasillaHistoria(294, 2); // casillaHist 2 (evento historia)
        mapa[2][9][5] = new CasillaMuro(295);
        mapa[2][9][6] = new CasillaMuro(296);
        mapa[2][9][7] = new CasillaMuro(297);
        mapa[2][9][8] = new CasillaMuro(298);
        mapa[2][9][9] = new CasillaMuro(299);

    }

    public void setMapa(Casilla[][][] mapa) {
        this.mapa = mapa;
    }

    public void ejecutarCasilla(Protagonista protagonista) {
        int piso = protagonista.getPiso();
        int y = protagonista.getPosicionY();
        int x = protagonista.getPosicionX();

        if (mapa[piso][y][x] != null) {
            mapa[piso][y][x].evento(protagonista);
        }
    }

    public void mostrarMapa(Protagonista protagonista) {
        int piso = protagonista.getPiso();
        int px = protagonista.getPosicionX();
        int py = protagonista.getPosicionY();

        System.out.println("Mapa [Piso " + piso + "]");
        System.out.println("---------------------------");

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                // Mostrar al protagonista
                if (y == py && x == px) {
                    System.out.print("O ");
                    continue;
                }

                Casilla casilla = mapa[piso][y][x];

                if (casilla == null || casilla instanceof CasillaMuro) {
                    System.out.print("# ");  // Muro o espacio no accesible
                } else if (casilla instanceof CasillaEscalera) {
                    System.out.print("E ");  // Escalera
                } else if (casilla instanceof CasillaHistoria) {
                    System.out.print("X ");  // Casilla de historia
                } else {
                    System.out.print("  ");  // Suelo transitable (2 espacios)
                }
            }
            System.out.println();  // Salto de línea al final de cada fila
        }
    }

}
