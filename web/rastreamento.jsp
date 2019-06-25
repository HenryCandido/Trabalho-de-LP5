
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rastreamento</title>
        <link rel="stylesheet" href="./css/estilo.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    </head>
    <body>
         <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp">Menu Principal</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="rastreamento.jsp">Rastreamento </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="cadastroProduto.jsp">Cadastrar Produto</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="cadastroCliente.jsp">Cadastrar Cliente</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="lerProduto.jsp">Ver produtos </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="lerCliente.jsp">Ver Clientes </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="apagarProduto.jsp">Apagar Produto</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="apagarCliente.jsp">Apagar Cliente</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="editarProduto.jsp">Editar Produto </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="editarCliente.jsp">Editar Cliente</a>
                    </li>
                </ul>
            </div>
        </nav>
        <h1>Rastreamento</h1>
        <br>
        <p>Insira o código do produto:</p>
        <input type="text" placeholder="Cód rastreio"/>
        <button>Rastrear</button>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    </body>
</html>
