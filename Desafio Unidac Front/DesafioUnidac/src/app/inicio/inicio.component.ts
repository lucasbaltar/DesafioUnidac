import { CoreEnvironment } from '@angular/compiler/src/compiler_facade_interface';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { Funcionario } from '../model/Funcionario';
import { Opcoes } from '../model/Opcoes';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {

  funcionario: Funcionario = new Funcionario()

  opcoes: Opcoes = new Opcoes

  constructor(
    private authService : AuthService,
    private router: Router
  ) { }

  ngOnInit(){
    window.scroll(0,0)

  }

  cadastrarFuncionario(){
    
    
    this.authService.cadastrarFuncionario(this.funcionario).subscribe((resp => {
      this.funcionario = resp
      alert('Usuário cadastrado com sucesso')
    }))

  }

  cadastrarItem(){
    this.authService.cadastrarItem(this.opcoes).subscribe((resp => {
      this.opcoes = resp
      alert('Item cadastrado com sucesso')
    }))

  }
  }

