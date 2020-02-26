import { Component, OnInit, TemplateRef } from '@angular/core';
import { FormGroup } from '@angular/forms';

import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';

import { TransportadoraService } from './app/transportadora.service';
import { Transportadora } from 'src/model/transportadora.model';
import { Endereco } from 'src/model/endereco.model';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'angula-base-transportadora';

  transportadoras: Transportadora[];
  transportadora: Transportadora;
  endereco: Endereco;

  modalRef: BsModalRef;

  constructor(private service: TransportadoraService, private modalService: BsModalService) { }

  ngOnInit() {
    this.transportadora = new Transportadora();
    this.endereco = new Endereco();

    this.service.getAll().subscribe(dados => this.transportadoras = dados);
  }

  /**
   * delete
   */
  public delete(transportadora: Transportadora) {
    if (confirm('Tem Certeza que deseja deletar' + transportadora.nome)) {
      this.service.delete(transportadora);
      location.reload();
    }
  }

  /**
   * openModal
   */
  public openModal(template: TemplateRef<any>, transportadora: Transportadora) {
    if (transportadora === null ) {
      this.modalRef = this.modalService.show(template);
    } else {
      this.transportadora = transportadora;
      this.endereco = this.transportadora.endereco[0];
      this.modalRef = this.modalService.show(template);
    }
  }

  /**
   * save
   */
  public save(frm: FormGroup) {
    if (this.transportadora.codigoTransportadora != null && this.transportadora.codigoTransportadora > 0) {
      this.service.update(this.transportadora);
      location.reload();
    } else {
      this.transportadora.endereco = [];
      this.transportadora.endereco.push(this.endereco);
      this.service.save(this.transportadora);
      location.reload();
    }
  }

}
