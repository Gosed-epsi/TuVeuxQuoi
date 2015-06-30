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

    public static boolean recherche(java.lang.String search) {
        i4.tvq.service.TuVeuxQuoiService_Service service = new i4.tvq.service.TuVeuxQuoiService_Service();
        i4.tvq.service.TuVeuxQuoiService port = service.getTuVeuxQuoiServicePort();
        return port.recherche(search);
    }

}
