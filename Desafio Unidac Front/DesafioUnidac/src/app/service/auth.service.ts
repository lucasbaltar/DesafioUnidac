import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Funcionario } from '../model/Funcionario';
import { Opcoes } from '../model/Opcoes';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http: HttpClient
  ) { }

  entrar() {

  }

  cadastrarFuncionario(funcionario: Funcionario): Observable<Funcionario> {
    return this.http.post<Funcionario>('https://desafiounidaclucasbaltar.herokuapp.com/funcionario/cadastrar', funcionario)

  }

  cadastrarItem(opcoes: Opcoes): Observable<Opcoes> {
    return this.http.post<Opcoes>('https://desafiounidaclucasbaltar.herokuapp.com/opcoes/cadastrar', opcoes)

  }

  getByNome(id: number): Observable<Funcionario>{
    return this.http.get<Funcionario>('https://desafiounidaclucasbaltar.herokuapp.com/funcionario/${nome}')
  }

  getAllFuncionario(): Observable<Funcionario[]>{
    return this.http.get<Funcionario[]>('https://desafiounidaclucasbaltar.herokuapp.com/funcionario/all')
  }

  getAllOpcoes(): Observable<Opcoes[]>{
    return this.http.get<Opcoes[]>('https://desafiounidaclucasbaltar.herokuapp.com/opcoes')
  }
  }
