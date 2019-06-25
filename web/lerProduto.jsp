<%-- 
    Document   : lerProduto
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
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">



        <title>Consultar Produtos</title>
    </head>
    <body>


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
                            <th>Id</th>
                            <th>Nome</th>
                            <th>Peso(kg)</th>
                            <th>Origem</th>
                            <th>Destino</th>
                            <th>Situação (State)</th>
                            <th>Situação Anterior</th>
                            <th>Ação</th>
                            <th>Alterar Situação da Encomenda</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${produtos}" var="produto">
                            <tr>
                                <td><c:out value="${produto.id}"></c:out></td>
                                <td><c:out value="${produto.nome}"></c:out></td>
                                <td><c:out value="${produto.peso}"></c:out></td>
                                <td><c:out value="${produto.remetente}"></c:out></td>
                                <td><c:out value="${produto.destino}"></c:out></td>
                                <td><c:out value="${produto.state}"></c:out></td>
                                <td><c:out value="${produto.memento}"></c:out></td>
                                <td><a href="FrontController?action=PrepararEditarProduto&textIdProduto=<c:out value="${produto.id}"/>"><i class="fas fa-edit"></i></a>
                                    <a href="FrontController?action=ExcluirProduto&textIdProduto=<c:out value="${produto.id}"/>"><i class="fas fa-trash"></i></a> </td>
                                <td>
                                    <a title="Entregar" href="FrontController?action=MudarEstadoProduto&op=entregar&estado=<c:out value="${produto.state}"/>&memento=<c:out value="${produto.memento}"/>&textIdProduto=<c:out value="${produto.id}"/>"><i class="fas fa-box-open"></i></a>
                                    <a title="Saiu para Entrega" href="FrontController?action=MudarEstadoProduto&op=sairParaEntregar&estado=<c:out value="${produto.state}"/>&memento=<c:out value="${produto.memento}"/>&textIdProduto=<c:out value="${produto.id}"/>"><i class="fas fa-people-carry"></i></a>
                                    <a title="Morador Ausente" href="FrontController?action=MudarEstadoProduto&op=moradorAusente&estado=<c:out value="${produto.state}"/>&memento=<c:out value="${produto.memento}"/>&textIdProduto=<c:out value="${produto.id}"/>"><i class="fas fa-frown"></i></a>
                                    <a title="Enviar" href="FrontController?action=MudarEstadoProduto&op=enviar&estado=<c:out value="${produto.state}"/>&memento=<c:out value="${produto.memento}"/>&textIdProduto=<c:out value="${produto.id}"/>"><i class="fas fa-truck-moving"></i></a>
                                    <a title="Voltar estado anterior" href="FrontController?action=MudarEstadoProduto&op=atualizarMemento&estado=<c:out value="${produto.state}"/>&memento=<c:out value="${produto.memento}"/>&textIdProduto=<c:out value="${produto.id}"/>"><i class="fas fa-history"></i></a>

                                    <!--
                                    <a title="Entregar" class="changeState" data-id="${produto.id}" data-op="entregar" data-state="${produto.state}" data-memento="${produto.memento}" href="javascript:void(0)"><i class="fas fa-box-open"></i></a>
                                    <a title="Saiu para Entrega" class="changeState" data-id="${produto.id}" data-op="sairParaEntregar" data-state="${produto.state}" data-memento="${produto.memento}" href="javascript:void(0)"><i class="fas fa-people-carry"></i></a>
                                    <a title="MoradorAusente" class="changeState" data-id="${produto.id}" data-op="moradorAusente" data-state="${produto.state}" data-memento="${produto.memento}" href="javascript:void(0)"><i class="fas fa-frown"></i></a>
                                    <a title="Enviar" class="changeState" data-id="${produto.id}" data-op="enviar" data-state="${produto.state}" data-memento="${produto.memento}" href="javascript:void(0)"><i class="fas fa-truck-moving"></i></a>
                                    <a title="Recuperar memento" class="changeState" data-id="${produto.id}"  data-op="atualizarMemento" data-state="${produto.state}" data-memento="${produto.memento}" href="javascript:void(0)"><i class="fas fa-history"></i></a>
                                    -->
                                </td>
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



