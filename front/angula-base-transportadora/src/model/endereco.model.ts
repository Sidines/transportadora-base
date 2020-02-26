import {Deserializable} from './deserializable.model';


export class Endereco implements Deserializable {

  public  codigoEndereco: number;

  public  rua: string;

  public  numero: string;

  public  bairro: string;

  public  cidade: string;

  public  uf: string;

  deserialize(input: any): this {
      return Object.assign(this, input);
  }
}
