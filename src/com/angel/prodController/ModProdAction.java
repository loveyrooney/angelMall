package com.angel.prodController;

import com.angel.comm.Action;
import com.angel.comm.Forward;
import com.angel.dto.ProdDTO;
import com.angel.service.ProdService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ModProdAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productNo = Integer.parseInt(request.getParameter("productNo"));
        ProdService service = ProdService.getService();
        ProdDTO dto = service.detailProd(productNo);
        request.setAttribute("dto",dto);
        System.out.println("modprodAction"+productNo);
        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("/WEB-INF/main.jsp?page=prod/modprod.jsp");
        return forward;
    }
}
