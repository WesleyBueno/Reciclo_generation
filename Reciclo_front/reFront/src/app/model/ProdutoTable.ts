import { CategoriaTable } from './CategoriaTable'

export class ProdutoTable{
    public idProduto!: number
    public produtoNome!: string
    public preco!: number
    public produtoFoto!: string
    public produtoDescricao!: string
    public produtoEstoque!: number /*?*/
    public produtoPeso!: number
    public categoria! : CategoriaTable
    public produtoFornecedor!: string
    public produtoTamanho!: string
    public produtoStatus!: string
}

