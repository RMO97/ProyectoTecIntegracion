package com.example.demo;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.perreria_uv_mx.lomitos.BuscarLomitoRequest;
import https.perreria_uv_mx.lomitos.BuscarLomitoResponse;
import https.perreria_uv_mx.lomitos.DeleteLomitoRequest;
import https.perreria_uv_mx.lomitos.DeleteLomitoResponse;
import https.perreria_uv_mx.lomitos.EditLomitoRequest;
import https.perreria_uv_mx.lomitos.EditLomitoResponse;
import https.perreria_uv_mx.lomitos.MostrarLomitosResponse;
import https.perreria_uv_mx.lomitos.RegistrarLomitoRequest;
import https.perreria_uv_mx.lomitos.RegistrarLomitoResponse;


//Declaracion de los Endpoints

@Endpoint
public class EndPoint {

    //Interface de Lomito
    @Autowired
    private iLomito ILomito;

    ArrayList<Lomito> lomitos = new ArrayList<Lomito>();

    @PayloadRoot(localPart = "RegistrarLomitoRequest", namespace = "https://perreria.uv.mx/lomitos")
    @ResponsePayload
    public RegistrarLomitoResponse Registrar(@RequestPayload RegistrarLomitoRequest peticion){
        RegistrarLomitoResponse respuesta = new RegistrarLomitoResponse();

        Lomito lomito = new Lomito();
        lomito.setNombre(peticion.getNombre());
        lomito.setEdad(peticion.getEdad());
        lomito.setRaza(peticion.getRaza());
        ILomito.save(lomito);
        respuesta.setRespuesta("Lomito registrado con nombre: " + peticion.getNombre());
        return respuesta;
    }


    @PayloadRoot(localPart = "BuscarLomitoRequest", namespace = "https://perreria.uv.mx/lomitos")
    @ResponsePayload
    public BuscarLomitoResponse Buscar(@RequestPayload BuscarLomitoRequest peticion){
        BuscarLomitoResponse respuesta = new BuscarLomitoResponse();
        Lomito lomito = new Lomito();
        lomito = ILomito.findById(peticion.getId()).get();
        respuesta.setNombre(lomito.getNombre());
        respuesta.setEdad(lomito.getEdad());
        respuesta.setRaza(lomito.getRaza());
        return respuesta;

    }

    //Endpoint para mostrar todos los lomitos registrados
    @PayloadRoot(localPart = "MostrarLomitosRequest", namespace = "https://perreria.uv.mx/lomitos")
    @ResponsePayload
    public MostrarLomitosResponse Buscar(){
        MostrarLomitosResponse respuesta = new MostrarLomitosResponse();
        //Guardamos todos  los lomitos en un iterable
        Iterable<Lomito> lista = ILomito.findAll();

        //Iteramos los lomitos para conseguir sus atributos
        //y agregarlos a la respuesta
        for(Lomito lomito : lista){
            MostrarLomitosResponse.Lomito l = new MostrarLomitosResponse.Lomito();
            l.setId(lomito.getId());
            l.setNombre(lomito.getNombre());
            l.setEdad(lomito.getEdad());
            l.setRaza(lomito.getRaza());
            respuesta.getLomito().add(l);
        }
        return respuesta;
        
    }

    @PayloadRoot(localPart = "DeleteLomitoRequest", namespace = "https://perreria.uv.mx/lomitos")
    @ResponsePayload
    public DeleteLomitoResponse Buscar(@RequestPayload DeleteLomitoRequest peticion){
        DeleteLomitoResponse respuesta = new DeleteLomitoResponse();
        respuesta.setRespuesta("Eliminado lomito con id: " + peticion.getId());
        ILomito.deleteById(peticion.getId());

        return respuesta;

    }

    @PayloadRoot(localPart = "EditLomitoRequest", namespace = "https://perreria.uv.mx/lomitos")
    @ResponsePayload
    public EditLomitoResponse Buscar(@RequestPayload EditLomitoRequest peticion){
        EditLomitoResponse respuesta = new EditLomitoResponse();
        Lomito lomito = new Lomito();
        lomito.setId(peticion.getId());
        lomito.setNombre(peticion.getNombre());
        lomito.setEdad(peticion.getEdad());
        lomito.setRaza(peticion.getRaza());
        ILomito.save(lomito);
        respuesta.setRespuesta("Lomito editado con id: " + peticion.getId());
        return respuesta;
    }

}
