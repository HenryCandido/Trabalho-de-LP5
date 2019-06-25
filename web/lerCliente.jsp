<%-- 
    Document   : lerCliente
    Created on : 09/05/2018, 17:13:36
    Author     : CGARA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <title>Consultar Clientes</title>
    </head>
    <body >
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp">Menu Principal</a>
                    </li>

                </ul>
            </div>
        </nav>
        <div class="container">
            <form >

                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Nome</th>
                            <th>CEP</th>
                            <th>CPF</th>
                            <th>Tipo Cliente</th>


                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${clientes}" var="cliente">
                            <tr>
                                <td><c:out value="${cliente.idCliente}"></c:out></td>
                                <td><c:out value="${cliente.nome}"></c:out></td>
                                <td><c:out value="${cliente.cep}"></c:out></td>
                                <td><c:out value="${cliente.cpf}"></c:out></td>
                                 <td><c:out value="${cliente.tipoCliente}"></c:out></td>

                                    <td><a href="FrontController?action=PrepararEditarCliente&textIdCliente=<c:out value="${cliente.idCliente}"/>&textTipoCliente=<c:out value="${cliente.tipoCliente}"/>"><i class="icon-edit"></i>Editar</a> </td>
                                <td><a href="FrontController?action=ExcluirCliente&textIdCliente=<c:out value="${cliente.idCliente}"/>"><i class="icon-remove"></i>Excluir</a> </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>  
            </form>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    </body>
</html>



