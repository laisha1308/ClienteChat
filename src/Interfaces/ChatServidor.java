package Interfaces;

import Interfaces.ChatCliente;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatServidor extends Remote {
    void registro(ChatCliente cliente) throws RemoteException;
    void mensaje(String mensaje) throws RemoteException;
}
