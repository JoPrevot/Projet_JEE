<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/style.css" />" />
<nav>
    <table class="menu">
    <thead>
    <tr>
      	<td><a href="<c:url value="/" />">Accueil</a></td>
      	
      	<td><a href="<c:url value="/liste-auteurs" />">Liste des auteurs</a></td>
      	
      	<td><a href="<c:url value="/liste-livres" />">Liste des livres</a></td>
    </tr>
    </thead>
    </table>
    
    
</nav>