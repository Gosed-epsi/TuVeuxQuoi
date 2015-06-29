/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i4.tvq.service.client;

/**
 *
 * @author Edgar
 */
public class ServiceClient {

    private static boolean recherche(java.lang.String arg0, int arg1) {
        i4.tvq.web.service.RechercheService_Service service = new i4.tvq.web.service.RechercheService_Service();
        i4.tvq.web.service.RechercheService port = service.getRechercheServicePort();
        return port.recherche(arg0, arg1);
    }

    public static boolean rechercheService(String recherche, int profondeur) {
        return recherche(recherche, profondeur);
    }

}
