import { ProdutoTable } from './ProdutoTable'

export class CategoriaTable{
    public idCategoria!: number
    public categoriaNome!: string
    public categoriaDescricao!:string
    public produto! : ProdutoTable[]
}