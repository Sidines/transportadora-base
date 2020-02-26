import {Deserializable} from './deserializable.model';
import {Endereco} from './endereco.model';

export class Transportadora implements Deserializable {

    public codigoTransportadora: number;

	public email: string;

	public nome: string;

	public empresa: string;

	public telefone: string; 
	
	public modal: string;

	public endereco: Endereco[];
  
  	deserialize(input: any): this {
      return Object.assign(this, input);
  	}
  
}