<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste d'auteurs</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/style.css" />" />
</head>
<body>
  <c:import url="/WEB-INF/menu.jsp" />
  </br>
  <div><a href="<c:url value="/ajouterAuteur" />"><button>Ajouter un auteur</button></a></div>
  </br>
  <c:choose>
    <c:when test="${ empty auteurs }">
       <p>Aucun auteur trouvé …</p>
    </c:when>
    <c:otherwise>
       <table>
         <thead>
           <th>Nom</th>
           <th>Prénom</th>
           <th>Téléphone</th>
           <th>Email</th>
           <th colspan="3">Actions</th>
         </thead>
         <tbody>
            <c:forEach items="${ auteurs }" var="auteur">
                <tr>
                    <td><c:out value="${auteur.nom }"/></td>
                    <td><c:out value="${auteur.prenom }"/></td>
                    <td><c:out value="${auteur.telephone }"/></td>
                    <td><c:out value="${auteur.email }"/></td>
                    <td>
                        <a href="<c:url value="/liste-auteurs">
                          <c:param name="id" value="${auteur.id }"/>
                        </c:url>">Voir les détails de l'auteur
                        </a>
                    </td>
                    <td>
                        <a href="<c:url value="/updateAuteur">
                          <c:param name="id" value="${auteur.id }"/>
                        </c:url>">Modifier l'auteur
                        </a>
                    </td>
                    <td>
                        <a href="<c:url value="/SupprimerAuteur">
                          <c:param name="id" value="${auteur.id }"/>
                        </c:url>">Supprimer l'auteur
                        </a>
                    </td>
                </tr>
            </c:forEach>

         </tbody>
       </table>
    </c:otherwise>
  </c:choose>
</body>
</html>