import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Funcionario } from '../model/Funcionario';
import { Opcoes } from '../model/Opcoes';
import { AuthService } from '../service/auth.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-itens',
  templateUrl: './itens.component.html',
  styleUrls: ['./itens.component.css']
})
export class ItensComponent implements OnInit {

  opcoes: Opcoes = new Opcoes()
  listaOpcoes : Opcoes[]

  funcionario : Funcionario = new Funcionario()
  listaFuncionario : Funcionario[];

  constructor(
    private authService : AuthService,
    private router: Router
  ) { }

  ngOnInit() {
    window.scroll(0,0)
    this.getAllFuncionario()
    this.getAllOpcoes()
  }

  getAllFuncionario() {
    this.authService.getAllFuncionario().subscribe((resp: Funcionario[]) => {
      this.listaFuncionario = resp
    })
  }

  getAllOpcoes() {
    this.authService.getAllOpcoes().subscribe((resp: Opcoes[]) => {
      this.listaOpcoes = resp
    })
  }

}
