# Papelaria — Atividade 8 de setembro

Aplicativo Android em Kotlin para registrar a compra de um material escolar, selecionar o material em uma lista e calcular subtotal, desconto e total.

## Fluxo

1. A tela inicial abre o lançamento.
2. No lançamento, informe código, quantidade, valor unitário e percentual de desconto. A lista retorna o código do material escolhido sem alterar os demais campos.
3. Confirme para conferir os dados na tela final.
4. Toque em Calcular para exibir os resultados.

## Materiais

| Código | Material |
| --- | --- |
| 1 | Caderno |
| 2 | Caneta |
| 3 | Lápis |
| 4 | Borracha |
| 5 | Régua |

O preço é informado pelo usuário. Os valores decimais devem usar ponto, por exemplo, `10.50`.

## Regras e cálculos

- Código: inteiro de 1 a 5.
- Quantidade: inteiro maior que zero.
- Valor unitário: maior que zero.
- Desconto: percentual de 0 a 100; informe 0 quando não houver desconto.
- Subtotal = quantidade × valor unitário.
- Valor do desconto = subtotal × percentual ÷ 100.
- Total a pagar = subtotal − valor do desconto.

## Estrutura principal

- `MainActivity`: tela inicial e acesso ao lançamento.
- `LancamentoActivity`: validação dos dados, abertura da lista e envio por Intent.
- `ListarActivity`: lista XML de materiais e retorno do código selecionado.
- `ConfirmarActivity`: exibição dos dados e cálculo sob demanda.
- `res/values/elementos.xml`: opções do `ListView`.

## Executar e verificar

Abra a pasta do projeto no Android Studio e aguarde a sincronização do Gradle. Para verificar e gerar o APK de depuração no Windows:

```text
.\gradlew.bat test assembleDebug
```

O APK de depuração é gerado em `app/build/outputs/apk/debug/app-debug.apk`.
