Feature: 自動販売機

  Scenario Outline: 有効通貨の確認
    Given 自動販売機がある
    When <insert_money>円を入金
    Then <current_money>円が入金されている
    Examples:
      | insert_money | current_money |
      | 1            | 0             |
      | 5            | 0             |
      | 10           | 10            |
      | 50           | 50            |
      | 100          | 100           |
      | 500          | 500           |
      | 1000         | 1000          |
      | 2000         | 0             |
      | 5000         | 0             |
      | 10000        | 0             |

  Scenario: 追加入金確認
    Given 自動販売機がある
    When 100円を入金
    And  100円を入金
    Then 200円が入金されている

  Scenario: エナジードリンクを追加
    Given 自動販売機がある
    When モンスターを1個補充
    Then モンスターの在庫が1個
